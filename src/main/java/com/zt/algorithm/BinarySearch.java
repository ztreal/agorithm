package com.zt.algorithm;

/**
 * BinarySearch 二分法查找.
 * User: zhangtan
 * Date: 13-8-13
 * Time: 下午4:54
 */
public class BinarySearch {


    public static int binarySearch(int[] targetArray, int aim) {
        int start = 0;
        int end = targetArray.length - 1;
        int mid = (start + end) / 2;
        while (targetArray[mid] != aim && end > start) {
            if (targetArray[mid] > aim) {
                end = mid - 1;
            } else if (targetArray[mid] < aim) {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return (targetArray[mid] != aim) ? -1 : mid;
    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};   //必须是已经排序好的数组
        System.out.println(binarySearch(target, 3));
    }
}
