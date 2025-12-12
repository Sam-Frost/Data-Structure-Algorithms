/*
 * Time Complexity : O(n*k) where n is number of stones and k is maximum jump distance
 * Space Complexity : O(n) for dp array 
 */
import java.util.Arrays;

public class FrogJumpWithKDistanceMemoization {

    public int frogJump(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return helper(heights, k, heights.length - 1, dp);
    }

    private int helper(int[] heights, int k, int index, int[] dp) {
        if (index <= 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int curr = Math.abs(heights[index] - heights[index - i]) + helper(heights, k, index - i, dp);
                min = Math.min(min, curr);
            }
        }

        return dp[index] = min;
    }
}
