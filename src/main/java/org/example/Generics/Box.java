package org.example.Generics;

public class Box <T>{
    T value; // T placeholder for any data type
    void set(T value){
        this.value=value;

    }
    T get(){
        return value;
    }
}
