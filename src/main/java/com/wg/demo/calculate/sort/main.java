package com.wg.demo.calculate.sort;

/**
 * @author wg
 * @date 2021/2/19
 */
public class main {

    public static void main(String[] args) {
        Selection selection  = new Selection();
        Comparable[] arr = {1,32,52,5,6,3,88,4,65};
        selection.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
