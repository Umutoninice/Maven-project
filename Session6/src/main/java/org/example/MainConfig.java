package org.example;

public class MainConfig {
    public static void main(String[] args) {
        System.out.println("JSON CONFIGURATION READER WITH GSON ");
        System.out.println("===================================");
        System.out.println();
        ConfigReader configReader= new ConfigReader();

        // successfully load config
        System.out.println("Successfully load config");
        try{
            AppConfig config=configReader.loadConfig("Config.json");
            configReader.validateConfig(config);
            System.out.println("Config loaded successfully");
            System.out.println("App Name: " + config.getAppName());
            System.out.println("Version: " + config.getVersion());
            System.out.println("Max Connections: " + config.getMaxConnections());
            System.out.println("Debug mode: " + config.isDebugMode());

            System.out.println("Full config ");
            System.out.println(config);
        }catch(ConfigLoadException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
    }
}
