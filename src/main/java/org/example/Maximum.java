package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Maximum {
    public static <T extends Comparable<T>> T findMax(List<T> list){
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("List can not be null or empty");
        }
         T max = list.get(0);
        for (T element : list){
            if (element.compareTo(max) > 0){
                max=element;
            }
        }
        return max;
    }
    public static <T> T findMax(List<T> list, Comparator<T> comparator){
        if (list==null || list.isEmpty() ){
            throw new IllegalArgumentException(" List can not be null or empty");
        }
        if(comparator == null){
            throw new IllegalArgumentException("Comparator can not be null");
        }
        T max = list.get(0);
        for (T element : list){
            if(comparator.compare(element, max) > 0){
                max= element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // test with integer list
        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(2);
        intList.add(6);
        intList.add(9);

        System.out.println("Integer list: " + intList);
        System.out.println("Max integer: " + Maximum.findMax(intList));

        // test with string list
        List<String> stringList= new ArrayList<>();
        stringList.add("apple");
        stringList.add("strawberry");
        stringList.add("banana");
        stringList.add("mango");

        System.out.println("String list: " + stringList);
        System.out.println("Max string(alphabetical): " + Maximum.findMax(stringList) );

    }
}
