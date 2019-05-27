package com.zt.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/6497958910492672
 * Gven a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:
 * <p>
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:
 * <p>
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
class CharacterReplacement {
    private static int findLength(String str, int k) {
        // TODO: Write your code here
        int left = 0, right = 0, maxSize = 0;
        Map<Character, Integer> keyMap = new HashMap<>();
        for (; right < str.length(); right++) {
            Character tempChar = str.charAt(right);
//            if (right > 1 && tempChar.equals(str.charAt(right - 1))) {
//                maxSize++;
//                continue;
//            }
            if (keyMap.containsKey(tempChar)) {
                if (right - keyMap.get(tempChar) - 1 < k) {
                    int contanLen = right - keyMap.get(tempChar) - 1;
                    maxSize = Math.max(maxSize, right - keyMap.get(tempChar) + 1 + (k - contanLen));
                } else {
                    left++;
                }
                if (right - keyMap.get(tempChar) - 1 > k) {
                    keyMap.remove(tempChar);
                }
            } else {
                keyMap.put(tempChar, right);
            }

        }
        if (maxSize > 0) {
            return maxSize;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
