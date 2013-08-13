package com.zt.algorithm;

/**
 * Inverse extrapolation逆推法.
 * User: zhangtan
 * Date: 13-7-29
 * Time: 下午4:55
 * 48个月，一个月取1000，整存零取年利率1.71%.
 */
public class Inversion {
    /**
     * 整存领取的利率
     */
    public static double RATE =  0.0315;
    /**
     * 每次取多少钱
     */
    public static int fetch=1000;

    public static void main(String[] args) {
        double[] corpus =new  double[49];
        int i ;
        corpus[48] = 1000;


        for (i=47;i>0;i--){
            corpus[i] = (corpus[i+1]+fetch)/(1+RATE/12);
        }

        for(i=48;i>0;i--){
            System.out.println("第"+i+"个月本利合计"+corpus[i]);
        }

     }

}
