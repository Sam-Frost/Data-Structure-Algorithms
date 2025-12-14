/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n) for dp array
 * 
 */

import java.util.Arrays;

public class GridUniquePathsMemoization {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(m, n, 0, 0, dp);
    }

    public int helper(int m, int n, int row, int col, int[][] dp) {

        // Reached end of matrix
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        // Invalid paths
        if (row >= m || col >= n) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // Move Down
        int down = helper(m, n, row + 1, col, dp);

        // Move Right
        int right = helper(m, n, row, col + 1, dp);

        return dp[row][col] = down + right;
    }
}
