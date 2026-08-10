package org.example;


import java.sql.SQLOutput;
import java.util.ArrayDeque;

public class StackQueue {
    /*
    Stack and queue using ArrayDeque
Implement a stack-based bracket checker: push opening brackets,
pop and verify on closing brackets.
Simulate a customer support queue: enqueue 5 customers,
 then dequeue them one by one printing "Now
serving: {name}".
Compare the time complexity of add/remove for
 ArrayList vs LinkedList in comments.
     */
public boolean checkBrackets(String expression) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
for(char ch: expression.toCharArray()){
    if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
    }else if (ch == ')' || ch ==']' || ch=='}') {
        if(stack.isEmpty()) {
            return false;
        }else{
            return false;
        }
    }

char top= stack.pop();
if(ch ==')' && top !='(' ) {
    return false;
}
if( ch == ']' && top != '['){
    return false;
}
if( ch== '}' && top!='{'){
    return false;
}
}
    return stack.isEmpty();
}
public void customerQueue(){
    ArrayDeque<String> queue = new ArrayDeque<>();

    System.out.println("\n Adding customers to queue:");
    System.out.println("Serving and removing customers");
    System.out.println("------------------------------");
    queue.offer("Alice");
    queue.offer("Nice");
    queue.offer("Keza");
    queue.offer("Diane");
    queue.offer("Ella");

    System.out.println("Queue size: " + queue.size());

    while(!queue.isEmpty()){
        String customer= queue.poll();

        System.out.println(" Serving: " + customer);
        System.out.println("Remaining: " + queue.size());

    }

}

    public static void main(String[] args) {
        StackQueue demo= new StackQueue();

        System.out.println("BRACKET CHECKER");
        System.out.println("---------------");

        String[] tests= {"()", "({[]})", "(()", "([)]", "(["};

        for (String test:tests){
            boolean result= demo.checkBrackets(test);
            System.out.println("test: " + (result ? "valid" : "invalid"));
            System.out.println();
        }

        System.out.println("CUSTOMER QUEUE");
        System.out.println("--------------");

        demo.customerQueue();
    }
}

