package com.zt.leetcode.LetterCombinationPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangtan
 * @version 1.0
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long start1 = System.currentTimeMillis();
        System.out.println(solution.letterCombinations("23"));
        System.out.println("one:" + String.valueOf(System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        System.out.println(solution.letterCombinations2("23"));
        System.out.println("two:" + String.valueOf(System.currentTimeMillis() - start2));

    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return helper(digits, 0, mapping);
    }

    private List<String> helper(String digits, int start, String[] str) {
        List<String> res = new ArrayList<>();
        if (start == digits.length()) {
            //不然返回的就是空，就不会把自己加进去了！！
            res.add("");
            return res;
        }

        int num = digits.charAt(start) - '0';
        List<String> tmp = helper(digits, start + 1, str);

        for (String ss : tmp) {
            for (int j = 0; j < str[num].length(); j++) {
                String s = str[num].charAt(j) + ss;
                res.add(s);
            }
        }
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] mapping = new String[]{
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            assert ans.peek() != null;
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }
}



