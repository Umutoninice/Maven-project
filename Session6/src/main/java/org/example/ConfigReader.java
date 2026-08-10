package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigReader {
    private static final Gson gson= new GsonBuilder().setPrettyPrinting().create();

    public AppConfig loadConfig(String filePath) throws ConfigLoadException {
        Path configPath = Paths.get(filePath);

        if (!Files.exists(configPath)) {
            throw new ConfigLoadException(filePath, "File not found at: " + configPath.toAbsolutePath());
        }
        if (!Files.isReadable(configPath)) {
            throw new ConfigLoadException(filePath, "File exists but is not readable");
        }
        AppConfig config;
        try {
            //reda json file content
            String jsonContent = Files.readString(configPath);
            // deserialize JSON to AppConfig object
            config = gson.fromJson(jsonContent, AppConfig.class);

            if (config == null) {
                throw new ConfigLoadException(filePath, "Deserialization resulted in null object");
            }
            return config;
        } catch (IOException e) {
            // handle file reading error
            throw new ConfigLoadException(filePath, e);
        } catch (JsonSyntaxException e) {
            // handle json error
            throw new ConfigLoadException(filePath, "Invalid json format: " + e.getMessage());
        }
    }
       public void validateConfig (AppConfig config) throws ConfigLoadException {
            if (config.getAppName() == null || config.getAppName().isEmpty()) {
                throw new ConfigLoadException("Missing or empty 'appName' field");
            }
            if (config.getVersion() == null || config.getVersion().isEmpty()) {
                throw new ConfigLoadException(" Missing or empty 'version' field ");
            }
            if (config.getMaxConnections() <= 0) {
                throw new ConfigLoadException("Invalid 'maxConnectons' must be greater than zero");
            }
        }
    }


