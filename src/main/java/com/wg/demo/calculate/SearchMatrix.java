package com.wg.demo.calculate;

/**
 * @author wg
 * @date 2021/3/30
 */
public class SearchMatrix {

    public static boolean search(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[row].length - 1;

        while (row < matrix.length && col > 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 35;
        search(matrix, target);

    }

}
