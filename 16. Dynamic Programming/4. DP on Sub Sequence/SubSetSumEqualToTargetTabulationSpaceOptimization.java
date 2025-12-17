/*
  * Time Complexity : O(n*target) 
 * Space Complexity : O(target) for dp array
 * 
 */

public class SubSetSumEqualToTargetTabulationSpaceOptimization {

    public boolean isSubsetSum(int[] arr, int target) {

        boolean[] dp = new boolean[target + 1];

        // First col = 0
        dp[0] = true;

        // First row set the 0
        if (arr[0] <= target) {
            dp[arr[0]] = true;
        }

        for (int i = 1; i < arr.length; i++) {

            boolean[] curr = new boolean[target + 1];

            // First col = 0
            curr[0] = true;

            for (int j = 1; j <= target; j++) {

                boolean notPick = dp[j];

                boolean pick = false;

                if (arr[i] <= j) {
                    pick = dp[j - arr[i]];
                }

                curr[j] = pick || notPick;
            }

            dp = curr;
        }

        return dp[target];
    }
}
