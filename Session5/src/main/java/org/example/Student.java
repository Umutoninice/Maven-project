
package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Student implements printable {
    static HashMap<String, ArrayList<Integer>> gradebook ;

    public Student() {
        gradebook= new HashMap<>();
    }

    public void addGrade(String student, int grade){
        if (grade <0 || grade>100){
            System.out.println("Invalid grade: " + grade + ", grade must be between 0 and 100.");
            return;
        }
        ArrayList<Integer> grades= gradebook.get(student);
        if(grades == null){
            grades = new ArrayList<>();
            gradebook.put(student, grades);
        }
        grades.add(grade);
        System.out.println("Added grade: " + grade + " for " + student );
    }
    public double computeAverage(String student) {
        ArrayList<Integer> grades = gradebook.get(student);
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    public void topStudent(){
        String topStudent =null;
        double highestAvg=0.0;
        for(Map.Entry<String,ArrayList<Integer>> entry: gradebook.entrySet()) {
            String student = entry.getKey();
            ArrayList<Integer> grades = entry.getValue();
            if(grades==null || grades.isEmpty()){
                continue;
            }
            int sum = 0;
            for (int grad : grades) {
                sum += grad;

            }
            double avg = (double) sum / grades.size();

            if (avg > highestAvg) {
                highestAvg = avg;
                topStudent = student;
            }
        }
        System.out.println(topStudent + " is the top student ");
    }
    public void report(){
        if(gradebook.isEmpty()){
            System.out.println("No students in gradebook.");
            return;
        }
        System.out.println(" STUDENT GRADES TRACKER");
        System.out.println("------------------------");
        for(Map.Entry<String,ArrayList<Integer>> entry: gradebook.entrySet()){
            String student = entry.getKey();
            ArrayList<Integer> grade = entry.getValue();
            double avg= computeAverage(student);

            System.out.println("Student: " + student + " Grades: " + grade + " Average: " + String.format("%.2f",computeAverage(student)) );
        }
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Student tracker= new Student();


        tracker.addGrade("Nice",90);
        tracker.addGrade("Nice",65);
        tracker.addGrade("Nice",78);

        tracker.addGrade("Keza",84);
        tracker.addGrade("Keza",98);
        tracker.addGrade("Keza",75);

        tracker.addGrade("Ella",190);

        tracker.report();
        tracker.topStudent();

        for(Map.Entry<String,ArrayList<Integer>>entry: tracker.gradebook.entrySet()){
            String name = entry.getKey();
            String student = entry.getKey();

        }


    }

    @Override
    public void printSummary() {
        System.out.println(gradebook );
    }
}

