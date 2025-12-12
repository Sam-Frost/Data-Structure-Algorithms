/*
 * Time Complexity : O(n)
 * Space Complexity : O(n) for dp array
 */

public class MaximumSumOfNonAdjacentElementsTabulation {

    public int nonAdjacent(int[] nums) {
        int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return helper(nums, nums.length-1, dp);
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + (i > 1 ? dp[i - 2] : 0);
            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[nums.length - 1];
    }
}
