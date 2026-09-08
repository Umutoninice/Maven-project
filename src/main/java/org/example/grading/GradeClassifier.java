package org.example.grading;

public class GradeClassifier {
    public static String classify(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");

        }
        if(score >= 90){
            return "A";
        }else if (score >= 75){
            return "B";
        }else if(score >= 60){
            return "C";
        }else if(score >= 50){
            return "D";
        }else{
            return "F";
        }

    }
}
