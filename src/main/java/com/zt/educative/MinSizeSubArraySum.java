package com.zt.educative;

/**
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/4578892830474240
 */
class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here
        int sum = 0;
        int left = 0;
        int right = 1;
        int minLength = Integer.MAX_VALUE;
        for (; right < arr.length; right++) {
            sum = sum + arr[right];
            while (sum >= S) {
                if (minLength > right - left) {
                    minLength = right - left;
                }
                sum -= arr[left];
                left++;
            }
        }
        if (minLength < Integer.MAX_VALUE) {
            return minLength + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result);
    }
}


