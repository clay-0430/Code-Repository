package com.wg.demo.test;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Random;

/**
 * @author wg
 * @date 2021/1/15
 */
@Data
public class DistributionConfigBO {

    private String distributeLevel;

    private Boolean distributeApplyEnable;


    private String distributeApplyFree;


    private String requirePurchaseItemId;


    private String requireOrderAmount;


    private String requireOrderQuantity;

    private String requireAgreementId;


    private Boolean requireName;


    private Boolean requireSex;


    private Boolean requireIdentity;

    private String spreadName;

    private String applyLink;

    private Integer applyAuditWay;


    private String customerBindingEnable;

    private Boolean distributorPurchaseRewardEnable;


    private String settlementType;

    private String cashSettlementType;

    private DistributionConfigVO distributionConfigVO;


    public static void main(String[] args) {

        Random random = new Random();
        System.out.println(random.nextInt(10000));

//        Long aLong = calculateRandom(4, 37L);
//        System.out.println(aLong);

    }

    private static Long calculateRandom(Integer count, Long orderTotalValue) {

        long min;
        long randomValue;
        long calculatePay = orderTotalValue * 30 / 100;

        Random random = new Random();
        switch (count) {
            //第一次扣减
            case 1:
                randomValue = random.nextInt(300 - 200 + 1) + 200;
                min = Math.min(randomValue, calculatePay);
                break;
            //第二次扣减
            case 2:
                randomValue = random.nextInt(200 - 100 + 1) + 100;
                min = Math.min(randomValue, calculatePay);
                break;
            default:
                min = random.nextInt(Math.min(100, (int) calculatePay) - 10 + 1) + 10;
        }
        return min;
    }

    private static String getRecordNo(Long userId) {
        Long n1 = decideN(userId, 12);
        Long n = n1 + System.currentTimeMillis() % 1000000000L;
        return decideN(n, 12) + "";
    }

    private static Long decideN(Long num, int n) {
        String numStr = num + "";
        String s = numStr.length() >= n ? numStr.substring(0, n) : StringUtils.rightPad(numStr, n, "0");
        return Long.valueOf(s);
    }
}
