/**
 * 一只青蛙，跳上台阶，一次可以跳一阶，或者一次跳两阶，问跳跃50阶台阶有多少种跳法？
 */
public class JumpFloor {


    private static long solution(long target) {

        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        return solution(target - 1) + solution(target - 2);
    }

    private static long solution2(long target) {

        if (target == 1)
            return 1;
        if (target == 2)
            return 2;

        long a = 2;
        long b = 1;
        long sum = 0;
        for (long i = 3; i <= target; i++) {
            sum = a + b;
            b = a;
            a = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int target = 41;

        long start = System.currentTimeMillis();
        long rs = solution(target);
        long end = System.currentTimeMillis();
        System.out.println("递归耗时：" + (end - start) + ", rs:" + rs);

        long start2 = System.currentTimeMillis();
        long rs2 = solution2(target);
        long end2 = System.currentTimeMillis();
        System.out.println("耗时：" + (end2 - start2) + ", rs:" + rs2);


    }

    /**
     * http://www.bkjia.com/ASPjc/1039868.html
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * <p>
     * 跳N级台阶问题
     *
     * @param number
     * @return
     */
    private int jumpFloorN(int number) {
        if (number == 1)
            return 1;
        else if (number == 2)
            return 2;
        else
            return jumpFloorN(number - 1) * 2;
    }
}
