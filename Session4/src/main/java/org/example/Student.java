package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String studentId;
    private final String name;
    private final List<Double> grades;

    public Student(String studentId, String name, double grades) {
        this.studentId = studentId;
        this.name = name;
        this.grades= new ArrayList<>();
    }

    public double addGrade(double grade) {
        if (grade < 0.0 || grade > 4.0) {
            throw new IllegalArgumentException("Grade must be between o.0 and 4.0 . Received: " + grade);
        }
        grades.add(grade);
    return 0;
    }


    public double computeGPA(){
        if ( grades.isEmpty()){
            return 0.0;
        }
            double sum=0.0;
        for(double grade : grades){
            sum +=grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return String.format("Student(StudentId=%s, name= %s, GPA=%.2f ",studentId,name,computeGPA());
    }

}
