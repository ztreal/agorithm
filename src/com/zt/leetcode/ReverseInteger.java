package algorithm;

/**
 * Copyright (c) 2018 meituan.com. All Rights Reserved.
 *
 * @author zhangtan
 * @version 1.0
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if (result != (newResult - tail) / 10)
                return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(3105));
    }
}
