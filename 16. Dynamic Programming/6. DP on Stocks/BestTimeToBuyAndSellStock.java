/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public int stockBuySell(int[] arr, int n) {

        int maxProfit = 0;

        int currMin = arr[0];

        for (int i = 1; i < n; i++) {

            maxProfit = Math.max(arr[i] - currMin, maxProfit);

            currMin = Math.min(currMin, arr[i]);
        }

        return maxProfit;
    }

}
