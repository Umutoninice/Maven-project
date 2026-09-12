package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1: Two Sum
 * Given an array of integers nums and an integer target, return the indices
 * of the two numbers such that they add up to target.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Map from value -> index of that value, so we can look up the
        // complement (target - nums[i]) in O(1) average time.
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution exists");
    }

    // Time complexity: O(n) - we make a single pass over the array, and each
    //                  HashMap get/put operation is O(1) on average.
    // Space complexity: O(n) - in the worst case (no early match), the map
    //                   ends up holding all n elements.

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] result = solver.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(java.util.Arrays.toString(result)); // [0, 1]
    }
}