package com.wg.demo.date;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wg
 * @date 2021/1/6
 */
public class LocalDateUtil {
    public static void main(String[] args) {


        String items = "110000200102001,110000200067001,110000200102002,110000200095001";
        Set<Long> collect = Arrays.stream(items.split(",")).map(Long::valueOf).collect(Collectors.toSet());
        System.out.println(collect);

//        DistributionConfigBO bo = null;
//        if (bo == null){
//            System.out.println(true);
//        }


//        if (!Strings.isNullOrEmpty("")){
//            System.out.println("sssss");
//        }else {
//            System.out.println("1dwqdq");
//        }
//        Long.valueOf("");


//        System.out.println(bo);
//        Map config = Maps.newConcurrentMap();
//        config.put("distribute.level", Objects.isNull(bo.getDistributeLevel())? " ": bo.getDistributeLevel());
//        config.put("distributor.purchase.reward.enable", Objects.isNull(bo.getDistributorPurchaseRewardEnable()) ? "false" : bo.getDistributorPurchaseRewardEnable().toString());
//        config.put("settlement.type", Objects.isNull(bo.getSettlementType())? " ": bo.getSettlementType());
//        config.put("distribution.config.customer.binding.enable", bo.getCustomerBindingEnable());
//        config.put("apply.audit.way", Objects.isNull(bo.getApplyAuditWay()) ? "1" : bo.getApplyAuditWay().toString());
//        config.put("apply.link", bo.getApplyLink());
//        config.put("spread.name", bo.getSpreadName());
//        config.put("require.identity", Objects.isNull(bo.getRequireIdentity()) ? "false" : bo.getRequireIdentity().toString());
//        config.put("require.sex", Objects.isNull(bo.getRequireSex()) ? "false" : bo.getRequireSex().toString());
//        config.put("require.name", Objects.isNull(bo.getRequireName()) ? "false" : bo.getRequireName().toString());
//        config.put("require.agreement.id", bo.getRequireAgreementId());
//        config.put("require.order.quantity", bo.getRequireOrderQuantity());
//        config.put("require.purchase.itemId", bo.getRequirePurchaseItemId());
//        config.put("distribution.apply.free", bo.getDistributeApplyFree());

//        if (Strings.isNullOrEmpty("")){
//            System.out.println("sssss");
//        };

//        Map<String, String> config = Maps.newConcurrentMap();
//        config.put("distribute.level",null);
//        config.put("settlement.type", null);
//        config.put("distribute.lesssvel","wsda");
//
//        LocalDate localDate = LocalDate.now();
//        LocalDate localDate1 = LocalDate.of(2021, 1, 4);
//
//        int year = localDate.getYear();
//        int year1 = localDate.get(ChronoField.YEAR);
//        Month month = localDate.getMonth();
//        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
//        int day = localDate.getDayOfMonth();
//        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
//
//        System.out.println("localDate:" + localDate
//                + "     localDate1:" + localDate1
//                + "     year:" + year
//                + "     year1:" + year1
//                + "     month:" + month
//                + "     month1:" + month1
//                + "     day:" + day
//                + "     day1:" + day1
//                + "     dayOfWeek:" + dayOfWeek
//                + "     dayOfWeek1:" + dayOfWeek1
//        );
    }


}
