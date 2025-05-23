package oda.api.tmf.codegen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static oda.api.tmf.codegen.CodeGenerator.*;

public class SchemaProcessor {
    private final OpenAPI openAPI;
    private final Set<String> generatedSchemas;
    private int inlineSchemaCounter;
    private final String apiDirGen;
    private static final Map<String, String> ABBREVIATIONS = new HashMap<>();
    static {
        // Từ khóa chung
        ABBREVIATIONS.put("Specification", "Spec");
        ABBREVIATIONS.put("Characteristic", "Char");
        ABBREVIATIONS.put("Value", "Val");
        ABBREVIATIONS.put("Relationship", "Rel");
        ABBREVIATIONS.put("Reference", "Ref");
        ABBREVIATIONS.put("Geographic", "Geo");
        ABBREVIATIONS.put("Address", "Addr");
        ABBREVIATIONS.put("Entity", "Ent");
        ABBREVIATIONS.put("Test", "Tst");
        ABBREVIATIONS.put("Order", "Ord");
        ABBREVIATIONS.put("Item", "Itm");
        ABBREVIATIONS.put("Service", "Svc");
        ABBREVIATIONS.put("Resource", "Res");
        ABBREVIATIONS.put("Product", "Prod");
        ABBREVIATIONS.put("Party", "Pty");
        ABBREVIATIONS.put("Customer", "Cust");
        ABBREVIATIONS.put("Billing", "Bill");
        ABBREVIATIONS.put("Account", "Acct");
        ABBREVIATIONS.put("Balance", "Bal");
        ABBREVIATIONS.put("Qualification", "Qual");
        ABBREVIATIONS.put("Offering", "Offr");
        ABBREVIATIONS.put("Promotion", "Promo");
        ABBREVIATIONS.put("Loyalty", "Lty");
        ABBREVIATIONS.put("Agreement", "Agrmt");
        ABBREVIATIONS.put("Use", "Use");
        ABBREVIATIONS.put("Catalog", "Cat");
        ABBREVIATIONS.put("Category", "Catg");
        ABBREVIATIONS.put("Ticket", "Tkt");
        ABBREVIATIONS.put("Location", "Loc");
        ABBREVIATIONS.put("Site", "Site");
        ABBREVIATIONS.put("Execution", "Exec");
        ABBREVIATIONS.put("Environment", "Env");
        ABBREVIATIONS.put("Data", "Data");
        ABBREVIATIONS.put("Schema", "Schm");
        ABBREVIATIONS.put("Instance", "Inst");
        ABBREVIATIONS.put("Definition", "Def");
        ABBREVIATIONS.put("Event", "Evt");
        ABBREVIATIONS.put("State", "St");
        ABBREVIATIONS.put("Type", "Typ");
        ABBREVIATIONS.put("NonFunctional", "NonFunc");
        ABBREVIATIONS.put("Functional", "Func");
        ABBREVIATIONS.put("Metric", "Mtr");
        ABBREVIATIONS.put("Measure", "Msr");
        ABBREVIATIONS.put("Threshold", "Thr");
        ABBREVIATIONS.put("Violation", "Vio");
        ABBREVIATIONS.put("Privacy", "Priv");
        ABBREVIATIONS.put("Profile", "Prof");
        ABBREVIATIONS.put("Partnership", "Prtn");
        ABBREVIATIONS.put("Sales", "Sls");
        ABBREVIATIONS.put("Lead", "Ld");
        ABBREVIATIONS.put("Quote", "Qt");
        ABBREVIATIONS.put("Price", "Prc");
        ABBREVIATIONS.put("Payment", "Pmt");
        ABBREVIATIONS.put("Cart", "Crt");
        ABBREVIATIONS.put("Inventory", "Inv");
        ABBREVIATIONS.put("Consumption", "Cons");
        ABBREVIATIONS.put("Recommendation", "Rec");
        ABBREVIATIONS.put("Problem", "Prob");
        ABBREVIATIONS.put("Level", "Lvl");
        ABBREVIATIONS.put("Objective", "Obj");
        ABBREVIATIONS.put("Candidate", "Cand");
        ABBREVIATIONS.put("Alarm", "Alm");
        ABBREVIATIONS.put("Device", "Dev");
        ABBREVIATIONS.put("Physical", "Phys");
        ABBREVIATIONS.put("Logical", "Log");
        ABBREVIATIONS.put("Bundle", "Bndl");
        ABBREVIATIONS.put("Bundled", "Bndl");
    }
    public SchemaProcessor(OpenAPI openAPI, String apiDirGen, Map<String, String[]> directoryMap, Map<String, String[]> configMap) {
        this.openAPI = openAPI;
        this.generatedSchemas = new HashSet<>();
        this.inlineSchemaCounter = 0;
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
        if (!isExítConfig("ignoreSchema", schemaName)) {
            SchemaAnalysisResult analysis = analyzeSchema(schema, new HashSet<>());
            String baseClass = analysis.baseClass;
            Map<String, Schema> properties = analysis.additionalProperties;
//            if (schemaName.contains("Ref")) properties = new HashMap<>();

            String className = renameEntity(schemaName, true);
            StringBuilder sb = new StringBuilder();
            String category = findCategoryByFileName(schemaName);
            if (category != null) {
                outputDir = apiDirGen + "/" + category.replace(".", "/");
                packageName = category;
            }
            if (isAbstractCatalogEntity(schemaName)) {
                baseClass = "AbstractCatalogEntity";
            } else {
                if (baseClass != null && !schemaName.endsWith("Ref")) {
                    baseClass = renameEntity(baseClass, true);
                } else if (isRef(schemaName)||schemaName.contains("RefOrValue") || schemaName.endsWith("Ref")) {
                    baseClass = "EntityRef";
                }
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
            sb.append("import java.util.logging.Logger;\n");
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
            if(isEmbeddable(schemaName)){
                sb.append("@Embeddable\n");
            }else {
                sb.append("@Entity\n");
            }

            sb.append("@Data\n");
            sb.append("@JsonInclude(JsonInclude.Include.NON_NULL)\n");
            sb.append("public class ").append(className);
            if (baseClass != null) {
                sb.append(" extends ").append(baseClass);
            }

            sb.append(" implements java.io.Serializable {\n");
            sb.append("    private final static long serialVersionUID = 1L;\n");
            sb.append("    private static final Logger logger = Logger.getLogger(Catalog.class.getName());\n");
            // Properties
            if (properties != null) {
                if(schemaName.equals("ProductSpecificationRef")){
                    System.out.println("");
                }
                if (baseClass != null && !baseClass.equals("Extensible")) {
                    properties.remove("id");
                    properties.remove("name");
                    properties.remove("href");
//                    properties.remove("description");
                    properties.remove("@type");
                    properties.remove("@baseType");
                    properties.remove("@schemaLocation");
                    properties.remove("@referredType");

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
                        if(isRef(javaType)){
                            if (isAbstractCatalogEntity(javaType)) {
                                sb.append("    @OneToMany(cascade = CascadeType.PERSIST)\n");
                                sb.append("    @JoinTable(name = \""+shortenIdentifier(schemaName+"_"+propName)+"\")\n");
//                                sb.append("            @JoinColumn(name=\"refId\", referencedColumnName = \"catalogId\")\n");
                            }else {
                                sb.append("    @OneToMany(cascade = CascadeType.PERSIST)\n");
                                sb.append("    @JoinTable(name = \""+shortenIdentifier(schemaName+"_"+propName)+"\")\n");
//                                sb.append("            @JoinColumn(name=\"refId\", referencedColumnName = \"id\")\n");
                            }

                        }else {
                            if (isAbstractCatalogEntity(javaType)) {
                                sb.append("    @OneToMany(cascade = CascadeType.PERSIST)\n");
                                sb.append("    @JoinTable(name = \""+shortenIdentifier(schemaName+"_"+propName)+"\")\n");
//                                sb.append("    @JoinColumns({\n");
//                                sb.append("            @JoinColumn(name=\"CATALOG_ID\", referencedColumnName = \"catalogId\"),\n");
//                                sb.append("            @JoinColumn(name=\"CATALOG_VERSION\", referencedColumnName = \"catalogVersion\"),\n");
//                                sb.append("            @JoinColumn(name=\"ENTITY_ID\", referencedColumnName = \"id\")\n");
//                                sb.append("    })\n");
                            }else {
                                sb.append("    @OneToMany(cascade = CascadeType.PERSIST)\n");
                                sb.append("    @JoinTable(name = \""+shortenIdentifier(schemaName+"_"+propName)+"\")\n");
//                                sb.append("    @JoinColumns({\n");
//                                sb.append("            @JoinColumn(name=\"ENTITY_ID\", referencedColumnName = \"id\")\n");
//                                sb.append("    })\n");
                            }

                        }


                    } else if (propSchema.get$ref() != null && !propName.equals("id")) {
                        if(isRef(javaType)){
                            if (isAbstractCatalogEntity(javaType)) {
                                sb.append("    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)\n");
//                                sb.append("    @JoinColumns({\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_CATALOG_ID\", referencedColumnName = \"catalogId\"),\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_CATALOG_VERSION\", referencedColumnName = \"catalogVersion\"),\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_ENTITY_ID\", referencedColumnName = \"id\")\n");
//                                sb.append("    })\n");
                            }else {
                                sb.append("    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)\n");
//                                sb.append("    @JoinColumns({\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_id\", referencedColumnName = \"refId\")\n");
//                                sb.append("    })\n");
                            }

                        }else {
                            if (isAbstractCatalogEntity(javaType)) {
                                sb.append("    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)\n");
//                                sb.append("    @JoinColumns({\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_CATALOG_ID\", referencedColumnName = \"catalogId\"),\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_CATALOG_VERSION\", referencedColumnName = \"catalogVersion\"),\n");
//                                sb.append("            @JoinColumn(name=\""+propName+"_ENTITY_ID\", referencedColumnName = \"id\")\n");
//                                sb.append("    })\n");
                            }else {
                                if(isEmbeddable(javaType)){
                                    sb.append("    @Embedded\n");
                                }else {
                                    sb.append("    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)\n");
//                                    sb.append("    @JoinColumns({\n");
//                                    sb.append("            @JoinColumn(name=\""+propName+"_ENTITY_ID\", referencedColumnName = \"id\")\n");
//                                    sb.append("    })\n");
                                }
                            }
                        }

                    }
                    sb.append("    private ").append(javaType).append(" ").append(renameEntity(propName, false)).append(";\n");
                }
            }
            /*if ((baseClass != null && baseClass.endsWith("Ref")) || schemaName.contains("RefOrValue") || schemaName.endsWith("Ref")) {
                sb.append("    @Override\n");
                sb.append("    public void fetchEntity(Class theClass, int depth) {\n");
                sb.append("    }\n");
            }*/
            /*else if (baseClass != null && (!baseClass.equals("AbstractCatalogEntity") || !baseClass.equals("AbstractEntity"))) {
                sb.append("    @Override\n");
                sb.append("    @JsonIgnore\n");
                sb.append("    public Logger getLogger() {\n");
                sb.append("        return logger;\n");
                sb.append("    }\n");
            }*/
            sb.append("}\n");
            Files.createDirectories(Paths.get(outputDir));
            String filePath = Paths.get(outputDir, fileName).toString();
            Files.writeString(Paths.get(filePath), sb.toString());
        }

    }
    private String shortenIdentifier(String name) {
        // Thay thế các từ dài bằng từ viết tắt
        int maxLength = 30;
        String result = name;
        for (Map.Entry<String, String> entry : ABBREVIATIONS.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }

        // Nếu vẫn vượt quá độ dài tối đa, cắt chuỗi
        if (result.length() > maxLength) {
            result = result.substring(0, maxLength);
            // Đảm bảo không cắt giữa dấu gạch dưới
            int lastUnderscore = result.lastIndexOf('_');
            if (lastUnderscore > 0 && lastUnderscore < maxLength - 1) {
                result = result.substring(0, lastUnderscore);
            }
        }

        return result;
    }
    private boolean isRef(String schemaName) {
        schemaName = schemaName.replace("List<", "").replace(">", "");
        return isExítConfig("Ref",schemaName);
    }
    private boolean isEmbeddable(String schemaName) {
        return isExítConfig("Embeddable",schemaName);
    }

    private boolean isAbstractCatalogEntity(String schemaName) {
        return isExítConfig("AbstractCatalogEntity",schemaName);
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
                    String refFileName = renameEntity(refSchemaName, true) + ".java";
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
                        String refFileName = renameEntity(refSchemaName, true) + ".java";
                        generateEntityClass(refSchemaName, refSchema, refFileName, outputDir, packageName, new HashSet<>());
                        generatedSchemas.add(refSchemaName);
                    }
                    visitedSchemas.remove(refSchemaName);
                }
            } else if (subSchema.getProperties() != null || subSchema.getAllOf() != null) {
                String inlineSchemaName = parentSchemaName + renameEntity(propertyName, true) + "Inline" + inlineSchemaCounter++;
                if (!visitedSchemas.contains(inlineSchemaName)) {
                    visitedSchemas.add(inlineSchemaName);
                    String inlineFileName = renameEntity(inlineSchemaName, true) + ".java";
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
            return renameEntity(ref, true);
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

    private String renameEntity(String name, boolean capitalizeFirst) {
        if ("Entity".equals(name)) return "AbstractEntity";
        if ("EntityRef".equals(name)) return "EntityRef";
        return name;
    }
}