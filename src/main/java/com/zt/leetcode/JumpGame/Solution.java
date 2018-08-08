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


    /**
     * 进一步思考，我们枚举每一位时都在判断是否被染色过（从而决定是否能够到达该点且能否继续往前走），假设在某一瞬间，
     * index=m 的位置已经被染色了，那么 index=n (n<=m) 的位置肯定已经被染色过了，我们维护一个最右边被染色的点，
     * 如果当前枚举点在该点的左侧，那么当前点已经被染色，否则即可停止遍历（因为右边的点再也不可能被染色到了）。
     * https://www.cnblogs.com/zichi/p/4808025.html
     *
     * @param nums
     * @return
     */


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

    /**
     * 记录到最后一个位置的最小的跳跃步数，检查当前位置是否可以跳到最小位置
     *
     * @param a
     * @param n
     * @return
     */
    private static boolean canJump(int a[], int n) {
        int last = n - 1, i;
        for (i = n - 1; i >= 0; i--) {
            if (i + a[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }

    /**
     * 局部解就是i + nums[i]，全局解就是最大的局部解。每次遍历开始先判断能不能走到这一步
     * 也就是（glo >= i）？，不符合的话直接break，因为如果能到达最后，肯定前边的都能到达。
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        //判断是不是能走到这里
        if (nums.length == 1)
            return true;
        int loc;
        int glo = 0;
        boolean res = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (glo < i)
                break;
            //局部解和全局解
            loc = i + nums[i];
            glo = Math.max(glo, loc);
        }
        if (glo >= nums.length - 1)
            res = true;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}, 5));
    }

    /**
     * 递归 O(n²)
     *
     * @param A
     * @return
     */
    public int jump(int[] A) {
        // state
        int[] steps = new int[A.length];

        // initialize
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        // function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        // answer
        return steps[A.length - 1];
    }
}
