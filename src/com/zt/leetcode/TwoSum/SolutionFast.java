package algorithm.TwoSum;

import java.util.Arrays;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 *
 * @author zhangtan
 * @version 1.0
 */
public class SolutionFast {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 11, 15, 22, 25, 27};
        SolutionFast solution = new SolutionFast();
        System.out.println(Arrays.toString(solution.twoSum(nums, 28)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] map = new int[16030];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i] + 5;
            if (diff < 0) continue;
            if (map[diff] > 0) {
                return new int[]{map[diff] - 1, i};
            }
            map[nums[i] + 5] = i + 1;
        }
        throw null;
    }
}
