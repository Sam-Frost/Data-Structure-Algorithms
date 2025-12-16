/*
 * Time Complexity : O(n^2)
 * Space Complexity : O(n^2) for dp array
 */
import java.util.Arrays;

public class MinimumPathSumInTraingularGridMemoization {

    public int minTriangleSum(int[][] triangle) {
        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            int[] tempArray = new int[triangle[i].length];
            Arrays.fill(tempArray, -1);
            dp[i] = tempArray;
        }

        return helper(triangle, 0, 0, dp);
    }

    private int helper(int[][] triangle, int row, int col, int[][] dp) {

        // Base case : Last possible value
        if (row == triangle.length - 1) {
            return triangle[row][col];
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = triangle[row][col] + helper(triangle, row + 1, col, dp);
        int downRight = triangle[row][col] + helper(triangle, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(down, downRight);
    }
}
