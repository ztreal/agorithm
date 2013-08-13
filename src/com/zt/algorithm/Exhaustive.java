package com.zt.algorithm;

import java.util.Calendar;

/**
 * Exhaustive 穷举.
 * User: zhangtan
 * Date: 13-8-13
 * Time: 上午10:25
 * 填数游戏：算法描述题*算=题题题题题题  求出每个字代表的数字.
 */
public class Exhaustive {

    public static void main(String[] args) {

        int multi, result;
        Calendar startDate = Calendar.getInstance();

        for (int i1=0; i1 <= 9; i1++) {
            for (int i2=0; i2 <= 9; i2++) {
                for (int i3=0; i3 <= 9; i3++) {
                    for (int i4=0; i4 <= 9; i4++) {
                        for (int i5=1; i5 <= 9; i5++) {
                           multi =  i1*10000 + i2*1000 + i3*100 + i4*10 + i5;
                           result = i5*100000 + i5*10000 + i5*1000 + i5*100 + i5*10 + i5;
                            if(multi*i1 == result){
                                System.out.println("i1="+i1+" i2="+i2+" i3="+i3+" i4="+i4+" i5="+i5);
                                System.out.println("result is "+result);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("耗时："+(Calendar.getInstance().getTimeInMillis() - startDate.getTimeInMillis())+"毫秒");
    }
}
