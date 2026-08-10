package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter FORMATTER= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final Path logFile;

    public Logger() {
        this("app.log");
    }

    public Logger(String fileName) {
        this.logFile = Paths.get(fileName);
    }
    private void log(String level, String message){
        String entry = String.format("[%s] %s: %s%n", LocalDateTime.now().format(FORMATTER), level,message);

        try{
            Files.writeString(logFile,entry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println("Failed to write log: " + e.getMessage());
        }
    }
    public void info(String message){
        log("INFO",message);
    }
    public void warn(String message){
        log("WARNING", message);
    }
    public void error(String message){
        log("ERROR", message);
    }
    public void clearLog() {
        try {
            Files.writeString(logFile, "", StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("Log file cleared successfully.");
        } catch (IOException e) {
            System.out.println("Failed to clear log: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Logger logger= new Logger();
        logger.info("Application started");
        logger.warn("Low memory");
        logger.error("Connection failed");
        logger.info("New features uploaded");
        logger.error("Failed to make update");

        //logger.clearLog();
    }

}
