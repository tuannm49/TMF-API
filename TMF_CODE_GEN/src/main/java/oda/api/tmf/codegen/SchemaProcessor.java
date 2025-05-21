package oda.api.tmf.codegen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static oda.api.tmf.codegen.CodeGenerator.findCategoryByFileName;
import static oda.api.tmf.codegen.CodeGenerator.findIgnoreByFileName;

public class SchemaProcessor {
    private final OpenAPI openAPI;
    private final Set<String> generatedSchemas;
    private int inlineSchemaCounter;
    private final Map<String, String[]> directoryMap;
    private final Map<String, String[]> configMap;
    private final String apiDirGen;

    public SchemaProcessor(OpenAPI openAPI, String apiDirGen, Map<String, String[]> directoryMap, Map<String, String[]> configMap) {
        this.openAPI = openAPI;
        this.configMap = configMap;
        this.generatedSchemas = new HashSet<>();
        this.inlineSchemaCounter = 0;
        this.directoryMap = directoryMap;
        this.apiDirGen = apiDirGen;
    }

    public void processSchema(String schemaName, String fileName, String outputDir, String packageName) throws IOException {
        if (!generatedSchemas.contains(schemaName)) {
            Schema schema = openAPI.getComponents().getSchemas().get(schemaName);
            if (schema == null) {
                System.err.println("Schema not found: " + schemaName);
                return;
            }
            generateEntityClass(schemaName, schema, fileName, outputDir, packageName, new HashSet<>());
            generatedSchemas.add(schemaName);
            //processReferencedSchemas(schema, outputDir, schemaName, schemaName, packageName, new HashSet<>());
        }
    }

    private static class SchemaAnalysisResult {
        public String baseClass;
        public Map<String, Schema> additionalProperties;

        public SchemaAnalysisResult(String baseClass, Map<String, Schema> additionalProperties) {
            this.baseClass = baseClass;
            this.additionalProperties = additionalProperties;
        }
    }

    private SchemaAnalysisResult analyzeSchema(Schema schema, Set<String> visitedSchemas) {
        if (schema.getAllOf() != null) {
            List<Schema> allOf = schema.getAllOf();
            String baseClass = null;
            Map<String, Schema> additionalProperties = new HashMap<>();

            for (Schema subSchema : allOf) {
                if (subSchema.get$ref() != null) {
                    if (baseClass == null) {
                        baseClass = subSchema.get$ref().replace("#/components/schemas/", "");
                    } else {
                        baseClass = null; // Nếu có nhiều $ref, tạm thời không coi là kế thừa
                        break;
                    }
                } else if (subSchema.getProperties() != null) {
                    additionalProperties.putAll(subSchema.getProperties());
                }
            }

            if (baseClass != null) {
                return new SchemaAnalysisResult(baseClass, additionalProperties);
            } else {
                Map<String, Schema> allProperties = new HashMap<>();
                for (Schema subSchema : allOf) {
                    if (subSchema.get$ref() != null) {
                        String refSchemaName = subSchema.get$ref().replace("#/components/schemas/", "");
                        if (!visitedSchemas.contains(refSchemaName)) {
                            visitedSchemas.add(refSchemaName);
                            Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                            if (refSchema != null) {
                                SchemaAnalysisResult refResult = analyzeSchema(refSchema, visitedSchemas);
                                allProperties.putAll(refResult.additionalProperties);
                            }
                            visitedSchemas.remove(refSchemaName);
                        }
                    } else if (subSchema.getProperties() != null) {
                        allProperties.putAll(subSchema.getProperties());
                    }
                }
                return new SchemaAnalysisResult(null, allProperties);
            }
        } else {
            return new SchemaAnalysisResult(null, schema.getProperties() != null ? schema.getProperties() : new HashMap<>());
        }
    }

    private void generateEntityClass(String schemaName, Schema schema, String fileName, String outputDir, String packageName, Set<String> visitedSchemas) throws IOException {
        if (!findIgnoreByFileName(configMap, schemaName)) {
            SchemaAnalysisResult analysis = analyzeSchema(schema, new HashSet<>());
            String baseClass = analysis.baseClass;
            Map<String, Schema> properties = analysis.additionalProperties;
            if (schemaName.contains("Ref")) properties = new HashMap<>();

            String className = toCamelCase(schemaName, true);
            StringBuilder sb = new StringBuilder();
            String category = findCategoryByFileName(directoryMap, schemaName);
            if (category != null) {
                outputDir = apiDirGen + "/" + category.replace(".", "/");
                packageName = category;
            }
            // Package và imports
            sb.append("package ").append(packageName).append(";\n\n");
            sb.append("import jakarta.persistence.*;\n");
            sb.append("import com.fasterxml.jackson.annotation.*;\n");
            sb.append("import org.springframework.data.mongodb.core.mapping.Document;\n");
            sb.append("import org.hibernate.annotations.GenericGenerator;\n");

            sb.append("import lombok.Data;\n");
            sb.append("import java.util.List;\n");
            sb.append("import java.util.Date;\n");
            sb.append("import oda.sid.tmf.model.others.*;\n");
            sb.append("import oda.sid.tmf.model.common.*;\n");
            sb.append("import oda.sid.tmf.model.customer.*;\n");
            sb.append("import oda.sid.tmf.model.party.*;\n");
            sb.append("import oda.sid.tmf.model.product.*;\n");
            sb.append("import oda.sid.tmf.model.resource.*;\n");
            sb.append("import oda.sid.tmf.model.sale.*;\n");
            sb.append("import oda.sid.tmf.model.service.*;\n");
            sb.append("import oda.sid.tmf.model.base.*;\n");
//            if (baseClass != null) {
//                sb.append("import ").append(packageName).append(".").append(toCamelCase(baseClass, true)).append(";\n");
//            }
            sb.append("\n");
            if (schemaName.contains("RelatedPartyRefOrPartyRoleRef")) {
                System.out.println("");
            }
            // Class annotations
            if (isEmbeddable(schemaName) || schemaName.endsWith("Ref") ||
                    schemaName.contains("RefOrValue") || (baseClass != null && baseClass.endsWith("Ref"))) {
                sb.append("@Embeddable\n");
            } else {
                sb.append("@Entity\n");
            }
            sb.append("@Data\n");
//            sb.append("@Document\n");
            sb.append("@JsonInclude(JsonInclude.Include.NON_NULL)\n");
            sb.append("public class ").append(className);

            if (isAbstractCatalogEntity(schemaName)) {
                sb.append(" extends AbstractCatalogEntity");
            } else {
                if (baseClass != null && !schemaName.endsWith("Ref")) {
                    sb.append(" extends ").append(toCamelCase(baseClass, true));
                } else if (schemaName.contains("RefOrValue") || schemaName.endsWith("Ref")) {
                    sb.append(" extends ").append("AbstractEntityRef");
                }
            }

            sb.append(" implements java.io.Serializable {\n");
            // Properties
            if (properties != null) {
                if (baseClass != null && !baseClass.equals("Extensible")) {
                    properties.remove("id");
                    properties.remove("baseType");
                    properties.remove("schemaLocation");
                    properties.remove("type");
                    properties.remove("referredType");
                    properties.remove("name");
                    properties.remove("href");
                    properties.remove("version");
                    properties.remove("description");
                }
                if (baseClass != null && baseClass.equals("Extensible") && !schemaName.endsWith("Ref") && properties.containsKey("id") == false) {
                    sb.append("    @Id\n");
                    sb.append("    @GeneratedValue(generator = \"UUID\")\n");
                    sb.append("    @GenericGenerator(name = \"UUID\",strategy = \"org.hibernate.id.UUIDGenerator\")\n");
                    sb.append("    private String id;");
                }
                for (var propEntry : properties.entrySet()) {
                    String propName = propEntry.getKey();
                    Schema propSchema = propEntry.getValue();
                    String javaType = getJavaType(propSchema, schemaName);

                    processReferencedSchemas(propSchema, outputDir, schemaName, propName, packageName, visitedSchemas);

                    if (propName.equals("id")) {
                        sb.append("    @Id\n");
                        sb.append("    @GeneratedValue(generator = \"UUID\")\n");
                        sb.append("    @GenericGenerator(name = \"UUID\",strategy = \"org.hibernate.id.UUIDGenerator\")\n");
                    }
                    if (propName.startsWith("@")) {
                        sb.append("    @JsonProperty(\"").append(propName).append("\")\n");
                        propName = propName.replace("@", "");
                    }
                    if ("array".equals(propSchema.getType()) && propSchema.getItems() != null && propSchema.getItems().get$ref() != null) {
                        if (javaType.contains("ProductOfferingRelationship")) {
                            System.out.println("");
                        }
                        if (javaType.contains("Ref") || javaType.contains("RefOrValue") || isRef(javaType)) {
                            sb.append("    @ElementCollection\n");
                            sb.append("    @CollectionTable(name = \"ProductOffering_" + propName + "\", joinColumns = {\n");
                            sb.append("            @JoinColumn(name = \"REF_ID\",referencedColumnName = \"id\"),\n");
                            sb.append("            @JoinColumn(name = \"REF_TYPE\",referencedColumnName = \"type\")\n");
                            sb.append("    })\n");
                        } else {
                            sb.append("    @OneToMany(cascade = CascadeType.PERSIST)\n");
                            sb.append("    @JoinColumn(name = \"").append(toCamelCase(schemaName, false)).append("_id\")\n");
                        }

                    } else if (propSchema.get$ref() != null && !propName.equals("id")) {
                        if (isEmbeddable(javaType)) {
                            sb.append("    @Embedded\n");
                            sb.append("    @AttributeOverrides({@AttributeOverride(name=\"type\", column=@Column(name = \"target_type\")),@AttributeOverride(name=\"schemaLocation\", column=@Column(name = \"target_schemaLocation\"))})\n");
                        } else if (javaType.contains("Ref") || isRef(javaType)) {
                            sb.append("    @Embedded\n");
                            sb.append("    @AttributeOverrides({\n");
                            sb.append("            @AttributeOverride(name=\"id\", column=@Column(name = \"" + propName + "_id\")),\n");
                            sb.append("            @AttributeOverride(name=\"name\", column=@Column(name = \"" + propName + "_name\")),\n");
                            sb.append("            @AttributeOverride(name=\"version\", column=@Column(name = \"" + propName + "_version\")),\n");
                            sb.append("            @AttributeOverride(name=\"href\", column=@Column(name = \"" + propName + "_href\")),\n");
                            sb.append("            @AttributeOverride(name=\"type\", column=@Column(name = \"" + propName + "_type\")),\n");
                            sb.append("            @AttributeOverride(name=\"baseType\", column=@Column(name = \"" + propName + "_baseType\")),\n");
                            sb.append("            @AttributeOverride(name=\"referredType\", column=@Column(name = \"" + propName + "_referredType\")),\n");
                            sb.append("            @AttributeOverride(name=\"schemaLocation\", column=@Column(name = \"" + propName + "_schemaLocation\"))\n");
                            sb.append("    })\n");
                        } else {
                            sb.append("    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)\n");
                            sb.append("    @JoinColumn(name = \"").append(toCamelCase(propName, false)).append("_id\")\n");
                        }
                    }
                    sb.append("    private ").append(javaType).append(" ").append(toCamelCase(propName, false)).append(";\n");
                }
            }
            if ((baseClass != null && baseClass.endsWith("Ref")) || schemaName.contains("RefOrValue") || schemaName.endsWith("Ref")) {
                sb.append("    @Override\n");
                sb.append("    public void fetchEntity(Class theClass, int depth) {\n");
                sb.append("    }\n");
            }
            sb.append("}\n");
            Files.createDirectories(Paths.get(outputDir));
            String filePath = Paths.get(outputDir, fileName).toString();
            Files.writeString(Paths.get(filePath), sb.toString());
        }

    }

    private boolean isEmbeddable(String schemaName) {
        for (String embeddedName : configMap.get("Embeddable")) {
            if (schemaName.equals(embeddedName)) return true;
        }
        return false;
    }

    private boolean isRef(String schemaName) {
        schemaName = schemaName.replace("List<", "").replace(">", "");
        for (String embeddedName : configMap.get("Ref")) {
            if (schemaName.equals(embeddedName)) return true;
        }
        return false;
    }

    private boolean isAbstractCatalogEntity(String schemaName) {
        for (String embeddedName : configMap.get("AbstractCatalogEntity")) {
            if (schemaName.equals(embeddedName)) return true;
        }
        return false;
    }

    private boolean isAbstractEntity(String schemaName) {
        if (isAbstractCatalogEntity(schemaName) == false && isEmbeddable(schemaName) == false && schemaName.endsWith("Ref"))
            return true;
        return false;
    }

    private boolean isMappedSuperclass(String schemaName) {
        for (String embeddedName : configMap.get("MappedSuperclass")) {
            if (schemaName.equals(embeddedName)) return true;
        }
        return false;
    }

    private void processReferencedSchemas(Schema schema, String outputDir, String parentSchemaName, String propertyName, String packageName, Set<String> visitedSchemas) throws IOException {

        if (visitedSchemas == null) {
            visitedSchemas = new HashSet<>();
        }

        if (schema.get$ref() != null) {
            String refSchemaName = schema.get$ref().replace("#/components/schemas/", "");
            if (!visitedSchemas.contains(refSchemaName) && !generatedSchemas.contains(refSchemaName) && !refSchemaName.equals(parentSchemaName)) {
                visitedSchemas.add(refSchemaName);
                Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                if (refSchema != null) {
                    String refFileName = toCamelCase(refSchemaName, true) + ".java";
                    generateEntityClass(refSchemaName, refSchema, refFileName, outputDir, packageName, visitedSchemas);
                    generatedSchemas.add(refSchemaName);
                }
                visitedSchemas.remove(refSchemaName);
            }
        }

        if ("array".equals(schema.getType()) && schema.getItems() != null) {
            processReferencedSchemas(schema.getItems(), outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
        }

        if (schema.getAllOf() != null) {
            List<Schema> lstAllOff = schema.getAllOf();
            for (Schema subSchema : lstAllOff) {
                processReferencedSchemas(subSchema, outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
            }
        }

        if (schema.getOneOf() != null) {
            processCompositeSchemas(schema.getOneOf(), outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
        }

        if (schema.getAnyOf() != null) {
            processCompositeSchemas(schema.getAnyOf(), outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
        }

        if (schema.getProperties() != null) {
            Map<String, Schema> lstAllOff = schema.getProperties();
            for (Map.Entry<String, Schema> propEntry : lstAllOff.entrySet()) {
                processReferencedSchemas(propEntry.getValue(), outputDir, parentSchemaName, propEntry.getKey(), packageName, visitedSchemas);
            }
        }
    }

    private void processCompositeSchemas(List<Schema> schemas, String outputDir, String parentSchemaName, String propertyName, String packageName, Set<String> visitedSchemas) throws IOException {
        for (Schema subSchema : schemas) {
            if (subSchema.get$ref() != null) {
                String refSchemaName = subSchema.get$ref().replace("#/components/schemas/", "");
                if (!visitedSchemas.contains(refSchemaName) && !generatedSchemas.contains(refSchemaName) && !refSchemaName.equals(parentSchemaName)) {
                    visitedSchemas.add(refSchemaName);
                    Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                    if (refSchema != null) {
                        String refFileName = toCamelCase(refSchemaName, true) + ".java";
                        generateEntityClass(refSchemaName, refSchema, refFileName, outputDir, packageName, new HashSet<>());
                        generatedSchemas.add(refSchemaName);
                    }
                    visitedSchemas.remove(refSchemaName);
                }
            } else if (subSchema.getProperties() != null || subSchema.getAllOf() != null) {
                String inlineSchemaName = parentSchemaName + toCamelCase(propertyName, true) + "Inline" + inlineSchemaCounter++;
                if (!visitedSchemas.contains(inlineSchemaName)) {
                    visitedSchemas.add(inlineSchemaName);
                    String inlineFileName = toCamelCase(inlineSchemaName, true) + ".java";
                    generateEntityClass(inlineSchemaName, subSchema, inlineFileName, outputDir, packageName, new HashSet<>());
                    generatedSchemas.add(inlineSchemaName);
                    visitedSchemas.remove(inlineSchemaName);
                }
            }
        }
    }

    private String getJavaType(Schema schema, String parentSchemaName) {
        if (schema.get$ref() != null) {
            String ref = schema.get$ref().replace("#/components/schemas/", "");
            return toCamelCase(ref, true);
        }
        if (schema.getOneOf() != null || schema.getAnyOf() != null) {
            return "String";
        }
        String type = schema.getType();
        String format = schema.getFormat();

        if ("string".equals(type)) {
            if ("date-time".equals(format)) {
                return "Date";
            }
            return "String";
        } else if ("integer".equals(type)) {
            return "Integer";
        } else if ("boolean".equals(type)) {
            return "Boolean";
        } else if ("number".equals(type)) {
            return "Integer";
        } else if ("array".equals(type)) {
            Schema items = schema.getItems();
            String itemType = getJavaType(items, parentSchemaName);
            return "List<" + itemType + ">";
        } else if ("object".equals(type)) {
            return "String";
        }
        return "String";
    }

    private boolean hasDateTime(Map<String, Schema> properties) {
        if (properties == null) return false;
        for (Schema prop : properties.values()) {
            if ("string".equals(prop.getType()) && "date-time".equals(prop.getFormat())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasArray(Map<String, Schema> properties) {
        if (properties == null) return false;
        for (Schema prop : properties.values()) {
            if ("array".equals(prop.getType())) {
                return true;
            }
        }
        return false;
    }

    private String toCamelCase(String name, boolean capitalizeFirst) {
        if ("Entity".equals(name)) return "AbstractEntity";
        if ("EntityRef".equals(name)) return "AbstractEntityRef";
        return name;
    }
}