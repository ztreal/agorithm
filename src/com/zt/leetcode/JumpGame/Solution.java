package com.zt.leetcode.JumpGame;

/**
 * 给定一组非负整数,起始位置是这一组非负整数的第一个整数的索引位置。
 * 该组整数中的每一个元素代表了在该元素位置可以向前跳跃的最大步长，判断是否可以调到最后一个位置
 * [2,3,1,1,4] true
 * [3,2,1,0,4] false
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int minimumReach = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= minimumReach) {
                minimumReach = 0;
            }
            minimumReach++;
        }
        return nums[0] >= minimumReach;
    }

    private static boolean canJump(int a[], int n) {
        int last = n - 1, i, j;
        for (i = n - 1; i >= 0; i--) {
            if (i + a[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
