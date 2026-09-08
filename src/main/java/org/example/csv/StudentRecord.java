package org.example.csv;

import java.util.ArrayList;
import java.util.List;

public class StudentRecord {
    private final String name;
    private final List<Integer> grades;

    public StudentRecord(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }
    public double getAverage(){
        return grades.stream()
                .mapToInt(Integer:: intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("StudentRecord{name=%s, grades=%s, average= %.2f}", name, grades, getAverage());
    }
}
