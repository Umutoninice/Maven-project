package org.example;

import java.util.Objects;

public class Pair <K, V>{
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {

        return first;
    }

    public void setFirst(K first) {

        this.first = first;
    }

    public V getSecond() {

        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
public Pair<V, K> swap() {

        return new Pair<>(this.second, this.first);
}

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static void main(String[] args) {
       Pair<String, Integer> nameAge= new Pair<>("Nice",23);
       Pair<Integer, String> idName= new Pair<>(26458,"Umutoni");

       System.out.println("Name: " + nameAge.getFirst());
       System.out.println("Age: " + nameAge.getSecond());


        //swap
       Pair<Integer, String> swapped = nameAge.swap();

        System.out.println("Swapped: " +swapped);

        //swapped pair
        System.out.println("Swapped first: " + swapped.getFirst());
        System.out.println("Swapped second: " + swapped.getSecond());

    }
}
