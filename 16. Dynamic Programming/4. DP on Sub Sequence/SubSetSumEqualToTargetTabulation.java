/*
  * Time Complexity : O(n*target) 
 * Space Complexity : O(n*target) for dp array 
 * 
 */

public class SubSetSumEqualToTargetTabulation {

    public boolean isSubsetSum(int[] arr, int target) {

        boolean[][] dp = new boolean[arr.length][target + 1];

        // First col all 0s
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        // First row set the 0
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {

                boolean notPick = dp[i - 1][j];

                boolean pick = false;

                if (arr[i] <= j) {
                    pick = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = pick || notPick;
            }
        }

        return dp[arr.length - 1][target];
    }

}
