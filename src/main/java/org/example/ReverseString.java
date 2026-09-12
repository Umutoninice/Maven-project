package org.example;

/**
 * LeetCode 344: Reverse String
 * Write a function that reverses a string. The input string is given as an
 * array of characters s, and it must be modified in place with O(1) extra
 * memory.
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        // Two-pointer swap: move inward from both ends until they meet.
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // Time complexity: O(n) - each character is visited (and swapped) once,
    //                  where n is the length of the array.
    // Space complexity: O(1) - the reversal is done in place using only a
    //                   constant number of extra variables (left, right, temp).

    public static void main(String[] args) {
        ReverseString solver = new ReverseString();
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        solver.reverseString(s);
        System.out.println(new String(s)); // "olleh"
    }
}
