package com.example.codegen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SchemaProcessor {
    private final OpenAPI openAPI;
    private final Set generatedSchemas;
    private final Map<String, Map<String, Schema>> allOfProperties;
    private int inlineSchemaCounter;


    public SchemaProcessor(OpenAPI openAPI) {
        this.openAPI = openAPI;
        this.generatedSchemas = new HashSet<>();
        this.allOfProperties = new HashMap<>();
        this.inlineSchemaCounter = 0;
    }

    /*public void processSchema(String schemaName, String fileName, String outputDir, String packageName) throws IOException {
        if (!generatedSchemas.contains(schemaName)) {
            Schema schema = openAPI.getComponents().getSchemas().get(schemaName);
            if (schema == null) {
                System.err.println("Schema not found: " + schemaName);
                return;
            }
            Map<String, Schema> properties = collectAllOfProperties(schema, new HashSet<>());
            generateEntityClass(schemaName, schema, properties, fileName, outputDir, packageName);
            generatedSchemas.add(schemaName);
        }
    }*/
    public void processSchema(String schemaName, String fileName, String outputDir, String packageName) throws IOException {
        if (!generatedSchemas.contains(schemaName)) {
            Schema schema = openAPI.getComponents().getSchemas().get(schemaName);
            if (schema == null) {
                System.err.println("Schema not found: " + schemaName);
                return;
            }
            Map<String, Schema> properties = collectAllOfProperties(schema, new HashSet<>());
            generateEntityClass(schemaName, schema, properties, fileName, outputDir, packageName, new HashSet<>());
            generatedSchemas.add(schemaName);
            // Xử lý các schema tham chiếu
            processReferencedSchemas(schema, outputDir, schemaName, schemaName, packageName, new HashSet<>());
        }
    }

    private Map<String, Schema> collectAllOfProperties(Schema schema, Set<String> visitedSchemas) {
        Map<String, Schema> properties = new HashMap<>();
        if (schema.getAllOf() != null) {
            List<Schema> lstSch = schema.getAllOf();
            for (Schema subSchema : lstSch) {
                if (subSchema.get$ref() != null) {
                    String refSchemaName = subSchema.get$ref().replace("#/components/schemas/", "");
                    if (!visitedSchemas.contains(refSchemaName)) {
                        visitedSchemas.add(refSchemaName);
                        Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                        if (refSchema != null) {
                            properties.putAll(collectAllOfProperties(refSchema, visitedSchemas));
                        }
                    }
                } else if (subSchema.getProperties() != null) {
                    properties.putAll(subSchema.getProperties());
                }
            }
        } else if (schema.getProperties() != null) {
            properties.putAll(schema.getProperties());
        }
        return properties;
    }

    private void generateEntityClass(String schemaName, Schema schema, Map<String, Schema> properties, String fileName, String outputDir, String packageName, Set<String> visitedSchemas) throws IOException {
        String className = toCamelCase(schemaName, true);
        StringBuilder sb = new StringBuilder();

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
        sb.append("\n");

        // Class annotations
        sb.append("@Entity\n");
        sb.append("@Data\n");
        sb.append("@JsonInclude(JsonInclude.Include.NON_NULL)\n");
        sb.append("public class ").append(className).append(" implements java.io.Serializable {\n");

        // Properties
        if (properties != null) {
            for (var propEntry : properties.entrySet()) {
                String propName = propEntry.getKey();
                Schema propSchema = propEntry.getValue();
                String javaType = getJavaType(propSchema, schemaName);

                // Sinh class cho schema tham chiếu, oneOf, anyOf
                processReferencedSchemas(propSchema, outputDir, schemaName, propName, packageName,visitedSchemas);

                // Xử lý quan hệ JPA
                if (propName.equals("id")) {
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

        // Ghi file
        String filePath = Paths.get(outputDir, fileName).toString();
        Files.writeString(Paths.get(filePath), sb.toString());
    }

    /*private void processReferencedSchemas(Schema schema, String outputDir, String parentSchemaName, String propertyName, String packageName) throws IOException {
        // Xử lý $ref trực tiếp
        if (schema.get$ref() != null) {
            String refSchemaName = schema.get$ref().replace("#/components/schemas/", "");
            if (!generatedSchemas.contains(refSchemaName) && !refSchemaName.equals(parentSchemaName)) {
                Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                if (refSchema != null) {
                    Map<String, Schema> refProperties = collectAllOfProperties(refSchema, new HashSet<>());
                    String refFileName = toCamelCase(refSchemaName, true) + ".java";
                    generateEntityClass(refSchemaName, refSchema, refProperties, refFileName, outputDir, packageName);
                    generatedSchemas.add(refSchemaName);
                }
            }
        }

        // Xử lý $ref trong array
        if ("array".equals(schema.getType()) && schema.getItems() != null) {
            processReferencedSchemas(schema.getItems(), outputDir, parentSchemaName, propertyName, packageName);
        }

        // Xử lý $ref trong allOf
        if (schema.getAllOf() != null) {
            List<Schema> lstSch = schema.getAllOf();
            for (Schema subSchema : lstSch) {
                processReferencedSchemas(subSchema, outputDir, parentSchemaName, propertyName, packageName);
            }
        }

        // Xử lý oneOf
        if (schema.getOneOf() != null) {
            processCompositeSchemas(schema.getOneOf(), outputDir, parentSchemaName, propertyName, packageName);
        }

        // Xử lý anyOf
        if (schema.getAnyOf() != null) {
            processCompositeSchemas(schema.getAnyOf(), outputDir, parentSchemaName, propertyName, packageName);
        }

        // Xử lý $ref trong properties
        if (schema.getProperties() != null) {
            Map<String,Schema> lstPro = schema.getProperties();
            for (Map.Entry<String, Schema> propEntry : lstPro.entrySet()) {
                processReferencedSchemas(propEntry.getValue(), outputDir, parentSchemaName, propEntry.getKey(), packageName);
            }
        }
    }

    private void processCompositeSchemas(List<Schema> schemas, String outputDir, String parentSchemaName, String propertyName, String packageName) throws IOException {
        for (int i = 0; i < schemas.size(); i++) {
            Schema subSchema = schemas.get(i);
            if (subSchema.get$ref() != null) {
                String refSchemaName = subSchema.get$ref().replace("#/components/schemas/", "");
                if (!generatedSchemas.contains(refSchemaName) && !refSchemaName.equals(parentSchemaName)) {
                    Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                    if (refSchema != null) {
                        Map<String, Schema> refProperties = collectAllOfProperties(refSchema, new HashSet<>());
                        String refFileName = toCamelCase(refSchemaName, true) + ".java";
                        generateEntityClass(refSchemaName, refSchema, refProperties, refFileName, outputDir, packageName);
                        generatedSchemas.add(refSchemaName);
                    }
                }
            } else if (subSchema.getProperties() != null || subSchema.getAllOf() != null) {
                // Sinh class cho schema inline
                String inlineSchemaName = parentSchemaName + toCamelCase(propertyName, true) + "Inline" + inlineSchemaCounter++;
                Map<String, Schema> inlineProperties = collectAllOfProperties(subSchema, new HashSet<>());
                String inlineFileName = toCamelCase(inlineSchemaName, true) + ".java";
                generateEntityClass(inlineSchemaName, subSchema, inlineProperties, inlineFileName, outputDir, packageName);
                generatedSchemas.add(inlineSchemaName);
            }
        }
    }
*/
    private void processReferencedSchemas(Schema schema, String outputDir, String parentSchemaName, String propertyName, String packageName, Set<String> visitedSchemas) throws IOException {
        // Khởi tạo visitedSchemas nếu null
        if (visitedSchemas == null) {
            visitedSchemas = new HashSet<>();
        }

        // Xử lý $ref trực tiếp
        if (schema.get$ref() != null) {
            String refSchemaName = schema.get$ref().replace("#/components/schemas/", "");
            if (!visitedSchemas.contains(refSchemaName) && !generatedSchemas.contains(refSchemaName) && !refSchemaName.equals(parentSchemaName)) {
                visitedSchemas.add(refSchemaName);
                Schema refSchema = openAPI.getComponents().getSchemas().get(refSchemaName);
                if (refSchema != null) {
                    Map<String, Schema> refProperties = collectAllOfProperties(refSchema, new HashSet<>(visitedSchemas));
                    String refFileName = toCamelCase(refSchemaName, true) + ".java";
                    generateEntityClass(refSchemaName, refSchema, refProperties, refFileName, outputDir, packageName,visitedSchemas);
                    generatedSchemas.add(refSchemaName);
                }
                visitedSchemas.remove(refSchemaName);
            }
        }

        // Xử lý $ref trong array
        if ("array".equals(schema.getType()) && schema.getItems() != null) {
            processReferencedSchemas(schema.getItems(), outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
        }

        // Xử lý $ref trong allOf
        if (schema.getAllOf() != null) {
            List<Schema> lstSch = schema.getAllOf();
            for (Schema subSchema : lstSch) {
                processReferencedSchemas(subSchema, outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
            }
        }

        // Xử lý oneOf
        if (schema.getOneOf() != null) {
            processCompositeSchemas(schema.getOneOf(), outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
        }

        // Xử lý anyOf
        if (schema.getAnyOf() != null) {
            processCompositeSchemas(schema.getAnyOf(), outputDir, parentSchemaName, propertyName, packageName, visitedSchemas);
        }

        // Xử lý $ref trong properties
        if (schema.getProperties() != null) {
            Map<String, Schema> lstPro =  schema.getProperties();
            for (Map.Entry<String, Schema> propEntry : lstPro.entrySet()) {
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
                        Map<String, Schema> refProperties = collectAllOfProperties(refSchema, new HashSet<>(visitedSchemas));
                        String refFileName = toCamelCase(refSchemaName, true) + ".java";
                        generateEntityClass(refSchemaName, refSchema, refProperties, refFileName, outputDir, packageName, new HashSet<>());
                        generatedSchemas.add(refSchemaName);
                    }
                    visitedSchemas.remove(refSchemaName);
                }
            } else if (subSchema.getProperties() != null || subSchema.getAllOf() != null) {
                String inlineSchemaName = parentSchemaName + toCamelCase(propertyName, true) + "Inline" + inlineSchemaCounter++;
                if (!visitedSchemas.contains(inlineSchemaName)) {
                    visitedSchemas.add(inlineSchemaName);
                    Map<String, Schema> inlineProperties = collectAllOfProperties(subSchema, new HashSet<>(visitedSchemas));
                    String inlineFileName = toCamelCase(inlineSchemaName, true) + ".java";
                    generateEntityClass(inlineSchemaName, subSchema, inlineProperties, inlineFileName, outputDir, packageName, new HashSet<>());
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
