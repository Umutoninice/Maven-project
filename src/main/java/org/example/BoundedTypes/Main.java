package org.example.BoundedTypes;

public class Main {
    public static void main(String[] args) {
        //integer
        Integer[] intNums= {10,20,30,40,50};
        Stats<Integer> intStats = new Stats<>(intNums);
        System.out.println("Integer average: " + intStats.average());

        // double
        Double[] doubleNums ={ 1.5, 2.5, 3.5, 4.5};
        Stats<Double> doubleStats = new Stats<>(doubleNums);
        System.out.println("Double average: " + doubleStats.average());
    }
}
