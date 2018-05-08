package algorithm;

import java.util.Arrays;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 * http://developer.51cto.com/art/201403/430986.htm
 * 在最坏的情况下，仍可能是相邻的两个数进行了交换。因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)
 *
 * @author zhangtan
 * @version 1.0
 */
public class Quicksort {
    public static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("l=" + (l + 1) + ",h=" + (h + 1) + ",povit=" + povit + "\n");
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
    }

    public static void main(String[] args) {
        int arr[] = {1, 24, 15, 87, 97, 0, 43241, 2, 4, 75, 782};
        sort(arr, 0, 10);
        System.out.println(Arrays.toString(arr));
    }
}
