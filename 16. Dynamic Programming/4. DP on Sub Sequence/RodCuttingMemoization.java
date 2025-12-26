/*
 * Time Complexity: O(N*N)
 * Space Complexity: O(N*N) for dp array
 */
import java.util.Arrays;

public class RodCuttingMemoization {

    public int RodCutting(int price[], int n) {
        int[][] dp = new int[n + 1][n];

        for (int i = 0; i < n + 1; i++) {
            int[] temp = new int[n];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }

        return helper(price, n, n - 1, dp);
    }

    private int helper(int price[], int n, int index, int[][] dp) {

        if (index == 0) {
            return price[0] * n;
        }

        if (dp[n][index] != -1) {
            return dp[n][index];
        }

        int notPick = helper(price, n, index - 1, dp);

        int pick = 0;
        int rodLength = index + 1;

        if (rodLength <= n) {
            pick = price[index] + helper(price, n - rodLength, index, dp);
        }

        return dp[n][index] = Math.max(pick, notPick);
    }
}
