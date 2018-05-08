package algorithm.BinarySearch;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 *
 * @author zhangtan
 * @version 1.0
 */
public class Solution {
    public static int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low) >>> 1;
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

    //递归
    public static int binarySearch(int[] arr, int des, int low, int high) {
        int middle = (low + high) / 2;
        if (des < arr[low] || des > arr[high] || low > high) {
            return -1;
        }
        if (arr[middle] < des) {
            return binarySearch(arr, des, middle + 1, high);
        } else if (arr[middle] > des) {
            return binarySearch(arr, des, low, middle - 1);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        Integer[] num = {1, 3, 6, 9, 11, 16, 20};
        System.out.println(binarySearch(num, 3));
    }
}
