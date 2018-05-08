package algorithm.ThreeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * a+b+c=0,find all unique triplets in the array,which gives the sum of zero
 * [-1,0,1,2,-1,-4]  a solution set is [-1,0,1],[-1,-1,2]
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sum = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(sum));
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }

            }
        }
        return res;
    }
}
