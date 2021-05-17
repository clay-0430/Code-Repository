package com.wg.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wg
 * @date 2021/1/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistributionConfigVO {

    private Integer distributeLevel;

    private Boolean distributeApplyEnable;

    private Boolean distributeApplyFree;

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

    private Boolean customerBindingEnable;

    private Boolean distributorPurchaseRewardEnable;

    private String settlementType;

    private String cashSettlementType;


}
