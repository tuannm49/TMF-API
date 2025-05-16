package com.example.codegen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.example.codegen.CodeGenerator.findCategoryByFileName;
import static com.example.codegen.CodeGenerator.findIgnoreByFileName;

public class SchemaProcessor {
    private final OpenAPI openAPI;
    private final Set<String> generatedSchemas;
    private int inlineSchemaCounter;
    private final Map<String, String[]> directoryMap;
    private final Map<String, String[]> ignoreSchema;
    private final String apiDirGen;
    public SchemaProcessor(OpenAPI openAPI, String apiDirGen, Map<String, String[]> directoryMap, Map<String, String[]> ignoreSchema) {
        this.openAPI = openAPI;
        this.ignoreSchema = ignoreSchema;
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
            processReferencedSchemas(schema, outputDir, schemaName, schemaName, packageName, new HashSet<>());
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
        if(!findIgnoreByFileName(ignoreSchema,schemaName)){
            SchemaAnalysisResult analysis = analyzeSchema(schema, new HashSet<>());
            String baseClass = analysis.baseClass;
            Map<String, Schema> properties = analysis.additionalProperties;

            String className = toCamelCase(schemaName, true);
            StringBuilder sb = new StringBuilder();
            String category = findCategoryByFileName(directoryMap,schemaName);
            if(category!=null){
                outputDir = apiDirGen+"/"+category.replace(".","/");
                packageName = category;
            }
            // Package và imports
            sb.append("package ").append(packageName).append(";\n\n");
            sb.append("import jakarta.persistence.Entity;\n");
            sb.append("import jakarta.persistence.Id;\n");
            sb.append("import jakarta.persistence.OneToMany;\n");
            sb.append("import jakarta.persistence.ManyToOne;\n");
            sb.append("import jakarta.persistence.JoinColumn;\n");
            sb.append("import com.fasterxml.jackson.annotation.JsonInclude;\n");
            sb.append("import com.fasterxml.jackson.annotation.JsonProperty;\n");
            sb.append("import com.fasterxml.jackson.annotation.JsonManagedReference;\n");
            sb.append("import com.fasterxml.jackson.annotation.JsonBackReference;\n");
            sb.append("import lombok.Data;\n");
            if (hasDateTime(properties)) {
                sb.append("import java.time.OffsetDateTime;\n");
            }
            if (hasArray(properties)) {
                sb.append("import java.util.List;\n");
            }
            if (baseClass != null) {
                sb.append("import ").append(packageName).append(".").append(toCamelCase(baseClass, true)).append(";\n");
            }
            sb.append("\n");

            // Class annotations
            sb.append("@Entity\n");
            sb.append("@Data\n");
            sb.append("@JsonInclude(JsonInclude.Include.NON_NULL)\n");
            sb.append("public class ").append(className);
            if (baseClass != null) {
                sb.append(" extends ").append(toCamelCase(baseClass, true));
            }
            sb.append(" implements java.io.Serializable {\n");

            // Properties
            if (properties != null) {
                for (var propEntry : properties.entrySet()) {
                    String propName = propEntry.getKey();
                    Schema propSchema = propEntry.getValue();
                    String javaType = getJavaType(propSchema, schemaName);

                    processReferencedSchemas(propSchema, outputDir, schemaName, propName, packageName, visitedSchemas);

                    if (propName.equals("id") && baseClass == null) {
                        sb.append("    @Id\n");
                    }
                    if (propName.startsWith("@")) {
                        sb.append("    @JsonProperty(\"").append(propName).append("\")\n");
                        propName = propName.replace("@", "");
                    }
                    if ("array".equals(propSchema.getType()) && propSchema.getItems() != null && propSchema.getItems().get$ref() != null) {
                        sb.append("    @OneToMany\n");
                        sb.append("    @JoinColumn(name = \"").append(toCamelCase(schemaName, false)).append("_id\")\n");
                        sb.append("    @JsonManagedReference\n");
                    } else if (propSchema.get$ref() != null && !propName.equals("id")) {
                        sb.append("    @ManyToOne\n");
                        sb.append("    @JoinColumn(name = \"").append(toCamelCase(propName, false)).append("_id\")\n");
                        sb.append("    @JsonBackReference\n");
                    }
                    sb.append("    private ").append(javaType).append(" ").append(toCamelCase(propName, false)).append(";\n");
                }
            }

            sb.append("}\n");
            Files.createDirectories(Paths.get(outputDir));
            String filePath = Paths.get(outputDir, fileName).toString();
            Files.writeString(Paths.get(filePath), sb.toString());
        }

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
            Map<String,Schema> lstAllOff = schema.getProperties();
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
            return "Object";
        }
        String type = schema.getType();
        String format = schema.getFormat();

        if ("string".equals(type)) {
            if ("date-time".equals(format)) {
                return "OffsetDateTime";
            }
            return "String";
        } else if ("integer".equals(type)) {
            return "Integer";
        } else if ("boolean".equals(type)) {
            return "Boolean";
        } else if ("array".equals(type)) {
            Schema items = schema.getItems();
            String itemType = getJavaType(items, parentSchemaName);
            return "List<" + itemType + ">";
        } else if ("object".equals(type)) {
            return "Object";
        }
        return "Object";
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
        return name;
    }
}