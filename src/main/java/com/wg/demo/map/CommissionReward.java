package com.wg.demo.map;

import lombok.Data;

import java.io.Serializable;

/**
 * 分销奖励
 *
 * @author : hancheng
 * @since : 2021/1/18
 */
@Data
public class CommissionReward implements Serializable {
    private static final long serialVersionUID = 896243253522029834L;

    /**
     * 奖励类型, 1:现金，2:优惠券，3.积分
     *
     */
    protected Integer rewardType;
}
