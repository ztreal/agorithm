package com.zt.algorithm;

/**
 * User: zhangtan
 * Date: 13-7-29
 * Time: 下午3:37
 * 斐波那契数列：如果一对兔子每月能生一对小兔子，而每对小兔在它出生后的第 3 个月里，又能开始生一对小兔子，假定在不发生死亡的情况下，
 * 由一对初生的兔子开始，一年后能繁殖成多少对兔子？
 */
public class Fibonacci {


    public static void main(String args[]) {
        int monthNum = 13;
        int rs[] = new int[13];
        rs[0] = 1;
        rs[1] = 1;

        for (int i = 2; i < monthNum; i++) {
            rs[i] = rs[i - 1] + rs[i - 2];
        }

        for (int ii = 1; ii < monthNum; ii++) {
            System.out.println("第" + ii + "个月的兔子为" + rs[ii]);
        }

    }
}
