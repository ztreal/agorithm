package algorithm.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * time complexity o(n)
 * space complexity o(n)
 * [2,7,11,15]，target = 9 因为2+7=9，return[0,1]
 * 给定一个整型数组，找出能相加起来等于一个特定目标数字的两个数。
 * 函数 twoSum 返回这两个相加起来等于目标值的数字的索引，且 index1 必须小于 index2。 请记住你返回的答案（包括 index1 和 index2）都不是从 0 开始的。
 * 你可以假定每个输入都有且仅有一个解决方案。
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, 18)));
    }

    private int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val == null) {
                map.put(nums[i], i);
            } else {
                arr[0] = val;
                arr[1] = i;
                break;
            }
        }
        return arr;
    }
}
