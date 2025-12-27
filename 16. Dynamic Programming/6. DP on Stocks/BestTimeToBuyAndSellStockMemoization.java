
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N*2) for dp array
 */
import java.util.Arrays;

public class BestTimeToBuyAndSellStockMemoization {

    public int stockBuySell(int[] arr, int n) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, 0, 0, dp);
    }

    private int helper(int[] arr, int index, int buy, int[][] dp) {

        if (index == arr.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;

        if (buy == 0) {
            profit = Math.max(
                    -arr[index] + helper(arr, index + 1, 1, dp), // Buy Stock
                    helper(arr, index + 1, 0, dp)
            
              
        /// Not Buy Stock
            );
        } else {
            profit = Math.max(
                    arr[index] + helper(arr, index + 1, 0, dp), // Sell Stock
                    helper(arr, index + 1, 1, dp) // Not Sell Stock
            );
        }

        return dp[index][buy] = profit;
    }
}
