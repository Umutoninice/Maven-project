package org.example;

public class AppConfig {
    private String appName;
    private String version;
    private int maxConnections;
    private boolean debugMode;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public AppConfig(String appName, String version, int maxConnections, boolean debugMode) {
        this.appName = appName;
        this.version = version;
        this.maxConnections = maxConnections;
        this.debugMode = debugMode;

    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appName='" + appName + '\'' +
                ", version='" + version + '\'' +
                ", maxConnections=" + maxConnections +
                ", debugMode=" + debugMode +
                '}';
    }
}
