/*
 * Time Complexity : O(n*target) where n is number of elements in array and target is sum/2
 * Space Complexity : O(n*target) for dp array
 * 
 */
import java.util.Arrays;

public class PartitionEqualSubsetSumMemoization {

    public boolean equalPartition(int n, int[] arr) {
        int target = 0;

        for (int i = 0; i < n; i++) {
            target += arr[i];
        }

        if (target % 2 != 0) {
            return false;
        }

        int[][] dp = new int[n + 1][];

        for (int i = 0; i < dp.length; i++) {
            int[] temp = new int[target + 1];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }

        return helper(n, arr, target / 2, 0, dp);
    }

    private boolean helper(int n, int[] arr, int target, int index, int[][] dp) {

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (index >= n) {
            return false;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean pick = helper(n, arr, target - arr[index], index + 1, dp);
        boolean notPick = helper(n, arr, target, index + 1, dp);

        dp[index][target] = pick || notPick ? 1 : 0;

        return pick || notPick;
    }
}
