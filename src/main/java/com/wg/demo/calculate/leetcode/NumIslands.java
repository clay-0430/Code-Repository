package com.wg.demo.calculate.leetcode;

/**
 * @Author : dongpo
 */
public class NumIslands {

    /**
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     */

    public static int numIslands(char[][] grid) {
        int col = grid.length;
        int row = grid[0].length;

        int res = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void infect(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = '2';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }


}
