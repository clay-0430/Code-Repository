package com.wg.demo.calculate.second.dp;

/**
 * @Author : dongpo
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length, cloumn = obstacleGrid[0].length;
        int[][] dp = new int[row][cloumn];

        for (int i = 0; i < row && obstacleGrid[i][0] < 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < cloumn && obstacleGrid[0][i] < 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloumn; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][cloumn - 1];
    }
}
