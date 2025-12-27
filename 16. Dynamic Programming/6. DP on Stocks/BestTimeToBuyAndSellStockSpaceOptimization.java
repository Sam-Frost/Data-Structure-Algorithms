
/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStockSpaceOptimization {

    public int stockBuySell(int[] arr, int n) {

        int[] prev = new int[2];
        int[] curr = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {

                int profit = 0;

                if (j == 0) {
                    profit = Math.max(
                            -arr[i] + prev[1], // Buy Stock
                            prev[0]
                    
                      
                /// Not Buy Stock
                    );
                } else {
                    profit = Math.max(
                            arr[i] + prev[0], // Sell Stock
                            prev[1] // Not Sell Stock
                    );
                }

                curr[j] = profit;
            }

            prev = curr;
        }

        return prev[0];
    }
}
