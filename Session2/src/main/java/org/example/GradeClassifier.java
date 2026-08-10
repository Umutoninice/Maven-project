package org.example;

public class GradeClassifier {
    public static String classify(int score){
      if(score >= 90){
          return "A";
      }else if(score >=75){
          return "B";
      }else if (score >=60){
          return "C";
      }else if (score >=50){
          return "D";
      }else if(score < 49){
          return "F";
        }else{
          return "Invalid";
      }
    }
   public static String classify(double percentage){
        if(percentage >= 90.0){
            return "A";
        }else if(percentage >=75.0){
            return "B";
        }else if(percentage >=60.0){
            return "C";
        }else if(percentage >=50.0){
            return "D";
        }else if(percentage < 49.0){
            return "F";
        }else{
            return "Invalid";
        }
   }

    public static void main(String[] args) {
        System.out.println("===INTEGER VALUES===");
        System.out.println();
        System.out.println("90 -> " + classify(90));
        System.out.println("78 -> " + classify(78));
        System.out.println("63 -> " + classify(63));
        System.out.println("52 -> " + classify(52));
        System.out.println("20 -> " + classify(20) );

        System.out.println();
        System.out.println("===Decimal percentages===");
        System.out.println();
        System.out.println("96.5 -> " + classify(96.5));
        System.out.println("86.5 -> " + classify(86.5));
        System.out.println("66.5 -> " + classify(66.5));
        System.out.println("56.5 -> " + classify(56.5));
        System.out.println("20.0 -> " + classify(20.0));
    }
}
