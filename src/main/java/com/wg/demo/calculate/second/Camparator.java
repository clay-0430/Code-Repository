package com.wg.demo.calculate.second;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author : dongpo
 */
public class Camparator {

    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "200");
        StopWatch stopWatch = new StopWatch("效率比拼");
//        stopWatch.start("Init test data");
        int size = 100000000;
        int[] intArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt();
        }
//        stopWatch.stop();
        int result;
        stopWatch.start("Iterator比较" + size + "个int最小值花费的时间");
        result = iteratorForMinInt(intArray);
        stopWatch.stop();
        System.out.println("Iterator比较" + size + "个int最小值: "+result);
        stopWatch.start("串行stream比较" + size + "个int最小值花费的时间");
        result = serialStreamForMinInt(intArray);
        stopWatch.stop();
        System.out.println("串行stream比较" + size + "个int最小值: " + result);
        stopWatch.start("并行stream比较" + size + "个int最小值花费的时间");
        result = parallelStreamForMinInt(intArray);
        stopWatch.stop();
        System.out.println("并行stream比较" + size + "个int最小值: " +result);
        System.out.println(stopWatch.prettyPrint());
    }

    public static int iteratorForMinInt(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static int serialStreamForMinInt(int[] arr) {
        return Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
    }

    public static int parallelStreamForMinInt(int[] arr) {
        return Arrays.stream(arr).parallel().min().orElse(Integer.MIN_VALUE);
    }

}
