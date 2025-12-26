/*
 * Time Complexity : O(n*n)
 * Space Complexity : O(n*n) for dp array
 */
public class RodCuttingTabulation {

    public int RodCutting(int price[], int n) {
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            dp[0][i] = price[0] * i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {

                int notPick = dp[i - 1][j];

                int pick = 0;
                int rodLength = i + 1;

                if (rodLength <= j) {
                    pick = price[i] + dp[i][j - rodLength];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
    }
}
