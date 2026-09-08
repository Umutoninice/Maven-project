package org.example.csv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvProcessor {
    private final FileReader fileReader;

    public CsvProcessor(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    public List<StudentRecord> processStudentGrades(String path){
        List<String> lines =fileReader.readLines(path);
        List<StudentRecord> records= new ArrayList<>();

        for (String line: lines){
            if(line == null || line.trim().isEmpty()){
                continue;
            }
            String[] parts = line.split(",");
            if(parts.length >= 2){
                String name= parts[0].trim();
                List<Integer> grades = new ArrayList<>();
                for( int i=1;i < parts.length;i++){
                    try{
                        grades.add(Integer.parseInt(parts[i].trim()));

                    }catch(NumberFormatException e){
                        System.err.println("Invalid grade: " + parts[i]);
                    }
                }
                if(!grades.isEmpty()){
                    records.add(new StudentRecord(name, grades));
                }
            }
        }
        return records;
    }
    public double calculateAverageGrade(String path){
        List<StudentRecord> records =processStudentGrades(path);
        if(records.isEmpty()){
            return 0.0;
        }
        double total=0;
        int count= 0;
        for ( StudentRecord record: records){
            for(int grade: record.getGrades()){
                total += grade;
                count++;
            }
        }
        return count >0 ? total/count : 0.0;
    }
    public Map<String, Double> getStudentAverage(String path){
        List<StudentRecord> records = processStudentGrades(path);
        Map<String, Double> averages= new HashMap<>();
        for(StudentRecord record:records){
            averages.put(record.getName(), record.getAverage());
        }
        return averages;
    }
}
