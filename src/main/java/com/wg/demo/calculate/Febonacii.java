package com.wg.demo.calculate;

/**
 * @author wg
 * @date 2021/2/15
 */
public class Febonacii {

    public static int febonacii(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return febonacii(n - 1) + febonacii(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(febonacii(100000000));
        System.out.println(febonacii(1));
        System.out.println(febonacii(2));
        System.out.println(febonacii(3));
        System.out.println(febonacii(4));
        System.out.println(febonacii(5));
        System.out.println(febonacii(6));
        System.out.println(febonacii(7));
    }
}
