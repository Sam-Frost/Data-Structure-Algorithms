/*
 * Time Complexity: O(N * amount)
 * Space Complexity: O(N * amount) for dp array
 */
import java.util.Arrays;

public class CoinChange2Memoization {

    public int count(int[] coins, int N, int amount) {

        int[][] dp = new int[N][amount + 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(coins, N, amount, N - 1, dp);
    }

    private int helper(int[] coins, int n, int amount, int index, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (index == 0) {
            return amount % coins[index] == 0 ? 1 : 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notPick = helper(coins, n, amount, index - 1, dp);
        int pick = 0;

        if (coins[index] <= amount) {
            pick = helper(coins, n, amount - coins[index], index, dp);
        }

        return dp[index][amount] = (pick + notPick) % 1000000007;
    }
}
