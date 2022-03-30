package com.wg.demo;

import lombok.Data;

import java.util.Random;

/**
 * @author wg
 */
@Data
public class sdasda {

    /**
     * 邀请人数
     */
    private Integer inviteNum;

    /**
     * 奖品名字
     */
    private String prizeName;

    /**
     * 奖品数量
     * -1不限，其余：1-999
     */
    private Integer prizeNum;

    private static Integer percentage = 30;


    public static void main(String[] args) {
        Long calculate = calculate(3, 5000l);
        System.out.println(calculate);
    }

    private static Long calculate(Integer count, Long orderTotalValue) {

        long min;
        long randomValue;
        Long calculatePay = orderTotalValue * percentage / 100;

        Random random = new Random();
        switch (count) {
            case 1:
                randomValue = random.nextInt(300 - 200 + 1) + 200;
                min = Math.min(randomValue, calculatePay);
                break;
            case 2:
                randomValue = random.nextInt(200 - 100 + 1) + 100;
                min = Math.min(randomValue, calculatePay);
                break;
            default:
                min = random.nextInt(Math.min(100, calculatePay.intValue())) + 10;
        }
        return min;
    }

}
