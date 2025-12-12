/*
 * Time Complexity : O(n)
 * Space Complexity : O(n) for dp array
 */
import java.util.Arrays;

public class FrogJumpWithKDistanceTabulation {

    public int frogJump(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);

        if (heights.length <= 1) {
            return 0;
        }

        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < heights.length; i++) {

            int curr = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;

            // Check for all possible values and get the min
            for (int j = i - 1; j >= i - k; j--) {
                // Going out of bound, break
                if (j < 0) {
                    break;
                }

                curr = Math.abs(heights[i] - heights[j]) + dp[j];
                min = Math.min(curr, min);

            }
            dp[i] = min;
        }

        return dp[heights.length - 1];
    }
}
