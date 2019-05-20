package com.zt.educative.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/5239377766645760
 * Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
 * <p>
 * You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * <p>
 * Write a function to return the maximum number of fruits in both the baskets.
 * <p>
 * Example 1:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * Example 2:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
class MaxFruitCountOf2Types {
    private static int findLength(char[] arr) {
        // TODO: Write your code here
        Set<Character> fruitType = new HashSet<>();
        int left = 0, right = 0, maxLen = -1;

        for (; right < arr.length; right++) {
            fruitType.add(arr[right]);
            if (fruitType.size() > 2) {
                fruitType.remove(arr[left]);
                left++;
            }
        }
        maxLen = Math.max(maxLen, right - left);
        return Math.max(-1, maxLen);
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
