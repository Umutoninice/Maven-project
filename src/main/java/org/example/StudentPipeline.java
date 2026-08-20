package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class StudentPipeline {

    static class Student {
        private String name;
        private double gpa;

        public Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }
        public double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {

            return String.format("%s (%.2f)", name, gpa);
        }
    }

    public static void main(String[] args) {
        // Sample list of students with varied GPAs
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.9),
                new Student("Nice", 2.8),
                new Student("Keza", 3.5),
                new Student("Diane", 3.2),
                new Student("Ivy", 4.0),
                new Student("Frank", 2.5),
                new Student("Grace", 3.8),
                new Student("Henry", 3.0),
                new Student("Manzi", 2.2),
                new Student("Jack", 3.6)
        );

        // 1. Filter GPA >= 3.0, sort by GPA descending, then name ascending
        List<Student> filteredAndSorted = students.stream()
                .filter(s -> s.getGpa() >= 3.0)
                .sorted(Comparator.comparingDouble(Student::getGpa)
                        .reversed()
                        .thenComparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("Filtered and sorted students (GPA >= 3.0):");
        filteredAndSorted.forEach(System.out::println);
        System.out.println();

        // 2. Partition by grade band (A/B/C/F)
        Map<String, List<Student>> gradeBandMap = students.stream()
                .collect(Collectors.groupingBy(s -> {
                    double gpa = s.getGpa();
                    if (gpa >= 3.7) return "A";
                    else if (gpa >= 3.0) return "B";
                    else if (gpa >= 2.0) return "C";
                    else return "F";
                }));

        System.out.println("Students grouped by grade band:");
        gradeBandMap.forEach((band, list) -> {
            System.out.println(band + ": " + list);
        });
        System.out.println();

        // 3. Honour-roll students (GPA >= 3.7) as comma-separated names
        String honourRollNames = students.stream()
                .filter(s -> s.getGpa() >= 3.7)
                .map(Student::getName)
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("Honour-roll students (GPA >= 3.7): " + honourRollNames);
    }
}