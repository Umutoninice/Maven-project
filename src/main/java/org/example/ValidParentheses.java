package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 20: Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[',
 * ']', determine if the input string is valid (every opening bracket is
 * closed by the same type of bracket, in the correct order).
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // Stack holds opening brackets we're still waiting to close.
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // A closing bracket with nothing to match, or the wrong
                // type of opening bracket on top, means the string is invalid.
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                boolean matches = (c == ')' && top == '(')
                        || (c == '}' && top == '{')
                        || (c == ']' && top == '[');
                if (!matches) {
                    return false;
                }
            }
        }

        // Valid only if every opening bracket found a match.
        return stack.isEmpty();
    }

    // Time complexity: O(n) - each character is pushed and/or popped from
    //                  the stack at most once, where n is the string length.
    // Space complexity: O(n) - in the worst case (e.g. all opening brackets),
    //                   the stack holds up to n characters.

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        System.out.println(solver.isValid("()[]{}")); // true
        System.out.println(solver.isValid("(]"));      // false
    }
}
