package org.example;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private ArrayList<T> elements;

    public Stack(ArrayList<T> elements) {

        this.elements = elements;
    }

    public Stack() {
this.elements = new ArrayList<>();
    }

    public void push(T element){

        elements.add(element);
    }
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();

        }
        return elements.remove(elements.size()-1);
    }
public  T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elements.get(elements.size()-1);
}
public boolean isEmpty(){

        return elements.isEmpty();
}
public int size(){

        return elements.size();
}
public void clear(){

        elements.clear();
}

    @Override
    public String toString() {

        return elements.toString();
    }
    public static void main(String[] args) {
        // Integer stack
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Stack: " + intStack);
        System.out.println("Peek: " + intStack.peek());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("After pop: " + intStack);

        // String stack
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        while (!stringStack.isEmpty()) {
            System.out.println("Popping: " + stringStack.pop());
        }
        // Output: Popping: World, Popping: Hello

        // Handling empty stack
        try {
            Stack<String> emptyStack = new Stack<>();
            emptyStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Cannot pop from empty stack!");
        }
    }
}
