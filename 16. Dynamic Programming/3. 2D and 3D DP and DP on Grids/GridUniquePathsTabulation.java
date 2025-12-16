/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n) for dp array
 * 
 */

import java.util.Arrays;

public class GridUniquePathsTabulation {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }

                int right = 0;
                int down = 0;
                // Move Right
                if (j > 0) {
                    right = dp[i][j - 1];
                }

                // Move Down
                if (i > 0) {
                    down = dp[i - 1][j];
                }

                dp[i][j] = right + down;
            }
        }

        return dp[m - 1][n - 1];
        // return helper(m, n, m-1, n-1, dp);
    }
}
