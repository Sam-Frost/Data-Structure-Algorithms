/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n) for dp array
 */

import java.util.Arrays;

public class UniquePathsWithObstacleMemoization {

    public int uniquePathsWithObstacles(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(matrix, matrix.length - 1, matrix[0].length - 1, dp);
    }

    private int helper(int[][] matrix, int row, int col, int[][] dp) {

        // Reached first cell
        if (row == 0 && col == 0 && matrix[row][col] == 0) {
            return 1;
        }

        // Invalid index
        if (row < 0 || col < 0) {
            return 0;
        }

        // Blocked Cell
        if (matrix[row][col] == 1) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left = helper(matrix, row, col - 1, dp);

        int up = helper(matrix, row - 1, col, dp);

        return dp[row][col] = left + up;
    }
}
