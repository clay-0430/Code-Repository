package com.wg.demo.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.JacksonUtils;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wg
 * @date 2021/1/29
 */
public class Runnnn {

    public static void main(String[] args) {
        List<CashRewardSingle> cashRewardSingleList = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {

            CashRewardSingle cashRewardSingle = new CashRewardSingle();
            cashRewardSingle.setLevel(i + 1);
            cashRewardSingle.setCommission("2312313");
            cashRewardSingle.setPlatform("123123");
            cashRewardSingle.setSeller("1231231");
            cashRewardSingleList.add(cashRewardSingle);
        }
        String json = JacksonUtils.toJson(CashReward.builder()
                .rewardType(1)
                .cashRewardSingleList(cashRewardSingleList)
                .build());
        System.out.println(json);

//        Object cashReward =  JSONObject.parse(json);

        CashReward cashReward = JSON.parseObject(json, CashReward.class);
        List<CashRewardSingle> cashRewardSingleList1 = cashReward.getCashRewardSingleList();


//        List<CashRewardSingle> cashRewardSingles = JSONObject.parseArray(json, CashRewardSingle.class);

        System.out.println(cashRewardSingleList1);

    }
}
