package com.wg.demo.map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单个规则
 *
 * @author : hancheng
 * @since : 2021/1/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CashRewardSingle extends CommissionReward {
    private static final long serialVersionUID = 1965045103039150141L;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 分佣比例
     */
    private String commission;

    /**
     * 平台承担
     */
    private String platform;

    /**
     * 商家承担
     */
    private String seller;
}
