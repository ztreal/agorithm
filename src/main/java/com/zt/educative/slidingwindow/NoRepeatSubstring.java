package com.zt.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/5485010335301632
 * Given a string, find the length of the longest substring which has no repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 * <p>
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 * <p>
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */

class NoRepeatSubstring {
    private static int findLength2(String str) {
        // TODO: Write your code here
        int left = 0, right = 0, maxSize = 0;
        Set<Character> characterHashSet = new HashSet<>();
        for (; right < str.length(); right++) {
            Character temp = str.charAt(right);
            while (characterHashSet.contains(temp)) {
                characterHashSet.remove(str.charAt(left));
                left++;
            }
            maxSize = Math.max(maxSize, right - left);
            characterHashSet.add(temp);
        }
        if (maxSize > 0) {
            return maxSize + 1;
        }
        return -1;
    }


    private static int findLength(String str) {
        // TODO: Write your code here
        int left = 0, right = 0, maxSize = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (; right < str.length(); right++) {
            Character temp = str.charAt(right);
            if (characterIntegerMap.containsKey(temp)) {
                left = characterIntegerMap.get(temp) + 1;
                characterIntegerMap.remove(str.charAt(left));
            }
            maxSize = Math.max(maxSize, right - left);
            characterIntegerMap.put(temp, right);
        }
        if (maxSize > 0) {
            return maxSize + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
