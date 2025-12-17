/*
  * Time Complexity : O(n*target) 
 * Space Complexity : O(n*target) for dp array 
 * 
 */

import java.util.Arrays;

public class SubSetSumEqualToTargetMemoization {

    public boolean isSubsetSum(int[] arr, int target) {

        int[][] dp = new int[arr.length + 1][target];

        for (int i = 0; i < dp.length; i++) {
            int[] temp = new int[target + 1];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }

        return helper(arr, target, 0, dp);
    }

    private boolean helper(int[] arr, int target, int index, int[][] dp) {

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (index >= arr.length) {
            return false;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean pick = helper(arr, target - arr[index], index + 1, dp);
        boolean notPick = helper(arr, target, index + 1, dp);

        dp[index][target] = pick || notPick ? 1 : 0;

        return pick || notPick;
    }
}
