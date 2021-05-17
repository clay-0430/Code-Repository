package com.wg.demo.map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 现金奖励
 *
 * @author : hancheng
 * @since : 2021/1/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CashReward implements Serializable {

    private static final long serialVersionUID = 4173632627614195357L;

    /**
     * 奖励类型
     *
     */
    private Integer rewardType = 1;

    /**
     * 奖励规则列表
     */
    private List<CashRewardSingle> cashRewardSingleList;
}
