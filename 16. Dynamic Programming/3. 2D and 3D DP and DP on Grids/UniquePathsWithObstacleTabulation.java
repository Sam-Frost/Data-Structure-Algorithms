/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n) for dp array
 */

public class UniquePathsWithObstacleTabulation {

    public int uniquePathsWithObstacles(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i == 0 && j == 0 && matrix[i][j] == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int right = 0;
                int down = 0;

                if (matrix[i][j] == 0) {
                    // Move right
                    if (j > 0) {
                        right = dp[i][j - 1];
                    }

                    // Move down
                    if (i > 0) {
                        down = dp[i - 1][j];
                    }
                }

                dp[i][j] = right + down;
            }
        }

        return dp[matrix.length - 1][matrix[0].length - 1];
    }
}
