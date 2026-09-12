package org.example;


/**
 * LeetCode 9: Palindrome Number
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Solved without converting the number to a string.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes (leading '-' has no mirror),
        // and any positive number ending in 0 (except 0 itself) can't be one
        // either, since a palindrome can't have a leading zero.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse only the second half of the number and compare it to the
        // remaining first half, stopping once reversedHalf >= x.
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even-length numbers, x == reversedHalf.
        // For odd-length numbers, drop the middle digit with reversedHalf / 10.
        return x == reversedHalf || x == reversedHalf / 10;
    }

    // Time complexity: O(log10 n) - we process roughly half the digits of x,
    //                  and the number of digits is proportional to log(x).
    // Space complexity: O(1) - only a few integer variables are used,
    //                   regardless of input size.

    public static void main(String[] args) {
        PalindromeNumber solver = new PalindromeNumber();
        System.out.println(solver.isPalindrome(121));  // true
        System.out.println(solver.isPalindrome(-121)); // false
        System.out.println(solver.isPalindrome(10));   // false
    }
}
