package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {


@Test
         void testIntegerList() {
            LinkedList<Integer> list = new LinkedList<>();

            // Test addLast
            System.out.println("Adding elements to end:");
            list.addLast(10);
            list.addLast(20);
            list.addLast(30);
            System.out.println("After addLast: " + list);
            System.out.println("Size: " + list.size());

            // Test addFirst
            list.addFirst(5);
            list.addFirst(1);
            System.out.println("After addFirst(5, 1): " + list);
            System.out.println("Size: " + list.size());

            // Test contains
            System.out.println("\nContains tests:");
            System.out.println("Contains 20? " + list.contains(20));
            System.out.println("Contains 100? " + list.contains(100));
            System.out.println("Contains null? " + list.contains(null));

            // Test toList
            List<Integer> javaList = list.toList();
            System.out.println("\ntoList(): " + javaList);

            // Test reverse
            System.out.println("\nBefore reverse: " + list);
            list.reverse();
            System.out.println("After reverse: " + list);

            // Test removeFirst
            Integer removed = list.removeFirst();
            System.out.println("\nRemoved first: " + removed);
            System.out.println("List after removeFirst: " + list);

            // Test removeLast
            removed = list.removeLast();
            System.out.println("Removed last: " + removed);
            System.out.println("List after removeLast: " + list);

        }

        @Test
        void testStringList() {
            LinkedList<String> list = new LinkedList<>();

            // Test with strings
            list.addLast("Apple");
            list.addLast("Banana");
            list.addLast("Mango");
            System.out.println("Initial list: " + list);

            list.addFirst("Orange");
            list.addFirst("Grape");
            System.out.println("After addFirsts: " + list);

            // Test contains with strings
            System.out.println("\nContains 'Banana'? " + list.contains("Banana"));
            System.out.println("Contains 'Orange'? " + list.contains("Orange"));
            System.out.println("Contains null? " + list.contains(null));

            // Test reverse
            System.out.println("\nBefore reverse: " + list);
            list.reverse();
            System.out.println("After reverse: " + list);


            // Test remove operations
            System.out.println("\nRemoving first: " + list.removeFirst());
            System.out.println("After removing first: " + list);
            System.out.println("Removing last: " + list.removeLast());
            System.out.println("After removing last: " + list);

            // Test toList
            List<String> javaList = list.toList();
            System.out.println("\ntoList(): " + javaList);
        }

       @Test
       void testMixedOperations() {
            LinkedList<Integer> list = new LinkedList<>();

            System.out.println("Initial empty list: " + list);
            System.out.println("Size: " + list.size());
            System.out.println("Is empty? " + list.isEmpty());

            // Mixed operations
            list.addFirst(1);
            list.addLast(2);
            list.addFirst(0);
            list.addLast(3);
            list.addFirst(-1);
            list.addLast(4);

            System.out.println("\nAfter mixed adds: " + list);
            System.out.println("Size: " + list.size());

            // Verify contains for all elements
            System.out.println("\nVerifying contains:");
            for (int i = -1; i <= 4; i++) {
                System.out.println("Contains " + i + "? " + list.contains(i));
            }

            // Mixed removes
            System.out.println("\nRemoving first: " + list.removeFirst());
            System.out.println("After first removal: " + list);
            System.out.println("Removing last: " + list.removeLast());
            System.out.println("After last removal: " + list);
            System.out.println("Removing first: " + list.removeFirst());
            System.out.println("After first removal: " + list);
            System.out.println("Removing last: " + list.removeLast());
            System.out.println("After last removal: " + list);

            // Final state
            System.out.println("\nFinal list: " + list);
            System.out.println("Size: " + list.size());
            System.out.println("Is empty? " + list.isEmpty());

            // Test reverse on remaining elements
            if (!list.isEmpty()) {
                list.reverse();
                System.out.println("After reverse: " + list);
            }
        }

}