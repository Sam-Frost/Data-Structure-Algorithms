/* 
 * Time Complexity : O(n)
 * Space Complexity : O(n) for dp array
 */
import java.util.Arrays;

public class ClimbingStairsMemoization {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int oneStep = dp[n - 1] != -1 ? dp[n - 1] : helper(n - 1, dp);

        int twoStep = 0;

        if (n >= 2) {
            twoStep = dp[n - 2] != -1 ? dp[n - 2] : helper(n - 2, dp);
        }

        return dp[n] = oneStep + twoStep;
    }
}
