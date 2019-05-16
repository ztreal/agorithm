package com.zt.educative;

/**
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/5698217712812032
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 **/

import java.util.HashMap;
import java.util.Map;

class LongestSubstringKDistinct {
    private static int findLength(String str, int k) {
        // TODO: Write your code here
        int left = 0, right = 0, len = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (; right < str.length(); right++) {
            Character temp = str.charAt(right);
            charMap.putIfAbsent(temp, right);
            if (charMap.size() > k) {
                charMap.remove(str.charAt(left));
                left++;
                continue;
            }
            if (charMap.size() == k && len < right - left) {
                len = right - left;
            }
        }
        if (len > 0) {
            return len + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}