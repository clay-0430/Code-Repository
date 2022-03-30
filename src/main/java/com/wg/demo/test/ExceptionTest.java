package com.wg.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author wg
 */
public class ExceptionTest {

    public static void main(String[] args) {


        IntStream.range(0, 100).mapToObj(i -> createLuckyRedPacketAmount(100, 10)).forEach(System.out::println);


//        try {
//            File f =new File("C:\\ProgramFile\\test.txt");
//            FileInputStream fis = new FileInputStream(f);
//        } catch (FileNotFoundException e) { //子类异常
//            System.out.println("子类异常");
//            e.printStackTrace();
//        } catch(IOException ie) {  //父类异常
//            System.out.println("父类异常");
//            ie.printStackTrace();
//        } catch(Exception e) { //基类运行时异常
//            System.out.println("基类异常");
//            e.printStackTrace();
//        }
    }

    public static Long createLuckyRedPacketAmount(long totalMoney, long totalCount) {
        if (totalMoney <= 0 || totalCount <= 0) {
            return null;
        }
        if (totalCount == 1) {
            return totalMoney;
        }
        Random random = new Random();
        return (long) random.nextInt((int) (2 * totalMoney / (totalCount + 1) - 1)) + 1;
    }

}
