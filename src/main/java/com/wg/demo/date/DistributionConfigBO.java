package com.wg.demo.date;

import lombok.Data;

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
}
