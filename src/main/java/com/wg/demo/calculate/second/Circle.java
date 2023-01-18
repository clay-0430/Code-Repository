package com.wg.demo.calculate.second;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author : dongpo
 */
public class Circle {


    public static void main(String[] args) throws UnsupportedEncodingException {

    }

    /**
     * 本题考察的是动态规划。
     * 如果你之前做过leetcode的70题爬楼梯，则应该比较容易理解：走n步到0的方案数=走n-1步到1的方案数+走n-1步到9的方案数。
     * 因此，若设dp[i][j]为从0点出发走i步到j点的方案数，则递推式为：
     * 图片
     * ps:公式之所以取余是因为j-1或j+1可能会超过圆环0~9的范围
     *
     * 我们可以想到，再回到0点可以从右面回来，也可以从左面回来，即先到达旁边的一个点，看看有多少回来的方法即可。所以运用动态规划的思想，我们可以写出递推式如下：
     *
     * d(k, j) = d(k-1, j-1) + d(k-1, j+1);
     *
     * d(k, j)表示从点j 走k步到达原点0的方法数， 因此可以转化为他相邻的点经过k-1步回到原点的问题，这样将问题的规模缩小。由于是环的问题， j-1, j+1可能会超出 0到n-1的范围，因此，我们将递推式改成如下：
     *
     *  d(k, j) = d(k-1, (j-1+n)%n) + d(k-1, (j+1)%n);
     * @param n
     * @return
     */
    private int circle(int n){


        return 0;
    }
}
