//package com.wg.demo.test;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.nacos.common.utils.JacksonUtils;
//
///**
// * @author wg
// * @date 2021/1/15
// */
//public class JsonTest {
//
//    public static void main(String[] args) {
//        DistributionConfigVO vo;
////        vo.setDistributeLevel(2);
////        vo.setDistributeApplyEnable(true);
////        vo.setDistributeApplyFree(true);
////        vo.setRequirePurchaseItemId("123123444");
////        vo.setRequireOrderAmount("13123123");
////        vo.setRequireOrderQuantity("123");
////        vo.setRequireAgreementId("13213");
////        vo.setRequireName(true);
////        vo.setRequireSex(false);
////        vo.setRequireIdentity(true);
////        vo.setSpreadName("扩展名称");
////        vo.setApplyLink("url");
////        vo.setApplyAuditWay(1);
////        vo.setCustomerBindingEnable(true);
////        vo.setDistributorPurchaseRewardEnable(false);
////        vo.setSettlementType("2");
////        vo.setCashSettlementType("1");
//
//
////        String voString = JSONObject.toJSONString(vo);
//        String voString = JacksonUtils.toJson(vo);
//        System.out.println(voString);
//
////        DistributionConfigVO distributionConfigVO = JSONObject.parseObject(voString, DistributionConfigVO.class);
//        DistributionConfigVO distributionConfigVO = JacksonUtils.toObj(voString, DistributionConfigVO.class);
//
//
//        System.out.println(distributionConfigVO);
//
//
//    }
//}
