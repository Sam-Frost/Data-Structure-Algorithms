/*
 * Time Complexity : O(n) 
 * Space Complexity : O(n) for dp array 
 * 
 */
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {

    public int nonAdjacent(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length - 1, dp);
    }

    private int helper(int[] nums, int index, int[] dp) {

        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            return nums[0];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int notPick = 0 + helper(nums, index - 1, dp);
        int pick = nums[index] + helper(nums, index - 2, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}
