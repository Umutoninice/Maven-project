package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class LinkedList <T>{
    // inner Node class
    private static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if (isEmpty()){
            head =  tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(T element){
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            head = tail =newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    // removes and return first element
    public T removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Can not remove from empty list");
        }
        T removedData = head.data;
        if(head == tail){
            head=tail=null;
        }else{
            head= head.next;
        }
        size--;
        return removedData;
    }
    // removes and return last element
public T removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Can not remove from empty list");

        }
        T removeData = tail.data;

        if(head == tail){
            head = tail = null;
        }else{
            Node<T> current = head;
            while( current.next != tail){
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return removeData;
}
//checks if the list contains a specific element
    public boolean contains(T element){
        Node<T> current = head;
        while( current != null){
            if(element == null ? current.data == null : element.equals(current.data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // returns number of elements in the list
    public int size(){
        return size;
    }
    // checks if the list is empty
    public boolean isEmpty(){
        return size==0;
    }
    public List<T> toList(){
        List<T> result= new ArrayList<>(size);
        Node<T> current = head;
        while (current != null){
            result.add(current.data);
                    current = current.next;
        }
        return result;
    }
    public void reverse(){
        if(isEmpty() || head==tail){
            return; // list is empty nothing to reverse
        }
        Node<T> prev = null;
        Node<T> current= head;
        tail = head;

        while(current != null){
            Node<T> next = current.next;
            current.next= prev;
            prev = current;
            current = next;
        }
        head= prev;
    }
}
