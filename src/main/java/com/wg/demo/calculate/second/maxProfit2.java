package com.wg.demo.calculate.second;

/**
 * @Author : dongpo
 */
public class maxProfit2 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, preHold + prices[i]);
            hold = Math.max(hold, preCash - prices[i]);
            preCash = cash;
            preHold = hold;
        }

        return cash;
    }
}
