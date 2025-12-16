/*
 * Time Complexity : O(n*n)
 * Space Complexity : O(n*n) for dp array
 */

import java.util.Arrays;

public class MinimumFallingPathSumTabulation {

    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            int[] temp = new int[matrix[i].length];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }

                int topl = 2_000_000;
                int topr = 2_000_000;

                int top = matrix[i][j] + dp[i - 1][j];
                if (j - 1 >= 0) {
                    topl = matrix[i][j] + dp[i - 1][j - 1];
                }
                if (j + 1 < matrix[i].length) {
                    topr = matrix[i][j] + dp[i - 1][j + 1];
                }

                dp[i][j] = Math.min(top, Math.min(topl, topr));
            }
        }

        for (int i = 0; i < matrix[matrix.length - 1].length; i++) {
            min = Math.min(min, dp[matrix.length - 1][i]);
        }

        return min;
    }

}
