/*
 * Time Complexity: O(N * amount)
 * Space Complexity: O(N * amount) for dp array
 */

public class CoinChange2Tabulation {

    public int count(int[] coins, int N, int amount) {

        int[][] dp = new int[N][amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= amount; j++) {

                int notPick = dp[i - 1][j];
                int pick = 0;

                if (coins[i] <= j) {
                    pick = dp[i][j - coins[i]];
                }

                dp[i][j] = (pick + notPick) % 1000000007;
            }
        }

        return dp[N - 1][amount];
    }

}
