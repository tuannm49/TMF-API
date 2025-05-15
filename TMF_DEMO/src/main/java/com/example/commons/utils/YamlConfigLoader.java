package com.example.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.InputStream;
import java.util.Map;

public class YamlConfigLoader {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> loadConfig(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try (InputStream inputStream = YamlConfigLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IllegalStateException("Cannot find file: " + filePath);
            }
            return mapper.readValue(inputStream, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML config: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getNestedValue(Map<String, Object> config, String... keys) {
        Object current = config;
        for (String key : keys) {
            if (!(current instanceof Map)) {
                throw new IllegalStateException("Invalid config path: " + String.join(".", keys));
            }
            current = ((Map<String, Object>) current).get(key);
            if (current == null) {
                throw new IllegalStateException("Config key not found: " + String.join(".", keys));
            }
        }
        return (T) current;
    }
}