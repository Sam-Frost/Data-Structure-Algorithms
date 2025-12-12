/*
 * Time Complexity : O(n) 
 * Space Complexity : O(n) for dp array 
 * 
 */

public class FrogJumpTabulation {

    public int frogJump(int[] heights) {
        if (heights.length <= 1) {
            return 0;
        }

        int[] dp = new int[heights.length];

        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < heights.length; i++) {

            int oneStep = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int twoStep = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[heights.length - 1];
    }
}
