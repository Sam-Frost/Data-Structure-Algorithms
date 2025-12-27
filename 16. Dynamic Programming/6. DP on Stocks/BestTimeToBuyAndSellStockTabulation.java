
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N*2) for dp array
 */
public class BestTimeToBuyAndSellStockTabulation {

    public int stockBuySell(int[] arr, int n) {
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {

                int profit = 0;

                if (j == 0) {
                    profit = Math.max(
                            -arr[i] + dp[i + 1][1], // Buy Stock
                            dp[i + 1][0]
                    
                      
                /// Not Buy Stock
                    );
                } else {
                    profit = Math.max(
                            arr[i] + dp[i + 1][0], // Sell Stock
                            dp[i + 1][1] // Not Sell Stock
                    );
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][0];
    }
}
