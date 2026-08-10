package org.example;

public class ConfigLoadException extends Exception {
    public ConfigLoadException(String message) {

        super(message);
    }
    public ConfigLoadException(String message,Throwable cause){
        super(message, cause);
    }
    public ConfigLoadException(String filePath, String reason){
        super(String.format("Failed to load configuration from '%s' : %s", filePath,reason ));
    }


}
