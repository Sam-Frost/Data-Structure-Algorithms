/*
 * Time Complexity : O(n*n)
 * Space Complexity : O(n*n) for dp array
 */

import java.util.Arrays;

public class MinimumFallingPathSumMemoization {

    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;

        int[][] dp = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            int[] temp = new int[matrix[i].length];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }

        // Check for each value of last row
        for (int i = 0; i < matrix[matrix.length - 1].length; i++) {
            int curr = helper(matrix, matrix.length - 1, i, dp);
            min = Math.min(curr, min);
        }

        return min;

    }

    private int helper(int[][] matrix, int row, int col, int[][] dp) {

        if (col < 0 || col >= matrix[row].length) {
            return 1_000_000;
        }

        if (row == 0) {
            return matrix[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int up = matrix[row][col] + helper(matrix, row - 1, col, dp);
        int upr = matrix[row][col] + helper(matrix, row - 1, col + 1, dp);
        int upl = matrix[row][col] + helper(matrix, row - 1, col - 1, dp);

        return dp[row][col] = Math.min(Math.min(up, upr), upl);
    }
}
