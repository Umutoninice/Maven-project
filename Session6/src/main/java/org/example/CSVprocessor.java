package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVprocessor {

    public static void main(String[] args) {
   String inputFile= "students.csv";
   String outputFile= "results.csv";
   try {
       Path inputPath = Paths.get(inputFile);
       if (!Files.exists(inputPath)) {
           System.out.println("File is not found: " + inputFile);
           System.out.println("Full path: " + inputPath.toAbsolutePath());
           return;
       }
       List<String> lines = Files.readAllLines(inputPath);
       if(lines.isEmpty()){
           System.out.println("File is empty");
           return;
       }
       //process data
       List<String> results= new ArrayList<>();
       results.add("name,average");
       int lineNumber=0;
       int processedCount=0;
       for(String line:lines){
           lineNumber++;
           if(line.trim().isEmpty()){
               continue;

           }
           // skip header
           if(lineNumber==1 && line.toLowerCase().contains("name")){
               continue;
           }
           String [] parts=line.split(",");
           if(parts.length < 4){
               System.out.println("Line " + lineNumber + " has wrong format " + line);
               continue;
           }
           try{
               String name=parts[0].trim();
               double grade1= Double.parseDouble(parts[1].trim());
               double grade2= Double.parseDouble(parts[2].trim());
               double grade3= Double.parseDouble(parts[3].trim());
               double average=(grade1 +grade2 + grade3)/3.0;
               results.add(name + "," + String.format("%.2f",average));
               System.out.println(name + " -> " + String.format("%.2f",average));
               processedCount++;

           }catch(NumberFormatException e){
               System.out.println("Line" + lineNumber + " has invalid numbers: " + line);
           }

       }
//write results
       Path outputPath= Paths.get(outputFile);
       Files.write(outputPath,results);
       System.out.println("Done! Processed " + processedCount + " students.");
       System.out.println("Results: " + outputPath.toAbsolutePath());
   }catch (IOException e){
       System.out.println("ERROR: " + e.getMessage());
       System.out.println("File path: " + Paths.get(inputFile).toAbsolutePath());
       e.printStackTrace();
   }
    }
}
