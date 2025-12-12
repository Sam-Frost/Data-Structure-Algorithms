
import java.util.Arrays;

public class FrogJumpMemoization {

    public int frogJump(int[] heights) {
        int[] memoization = new int[heights.length];
        Arrays.fill(memoization, -1);
        return helper(heights, heights.length - 1, memoization);
    }

    private int helper(int[] heights, int index, int[] memoization) {

        if (index <= 0) {
            return 0;
        }

        if (memoization[index] != -1) {
            return memoization[index];
        }

        int left = Math.abs(heights[index] - heights[index - 1]) + helper(heights, index - 1, memoization);
        int right = Integer.MAX_VALUE;

        if (index >= 2) {
            right = Math.abs(heights[index] - heights[index - 2]) + helper(heights, index - 2, memoization);
        }

        return memoization[index] = Math.min(left, right);
    }
}
