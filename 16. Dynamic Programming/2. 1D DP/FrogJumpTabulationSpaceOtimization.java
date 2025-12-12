/*
 * Time Complexity : O(n) 
 * Space Complexity : O(1)
 * 
 */
public class FrogJumpTabulationSpaceOtimization {

    public int frogJump(int[] heights) {

        if (heights.length <= 1) {
            return 0;
        }

        int twoStep = 0;
        int oneStep = Math.abs(heights[1] - heights[0]);

        for (int i = 2; i < heights.length; i++) {

            int onej = Math.abs(heights[i] - heights[i - 1]) + oneStep;
            int twoj = Math.abs(heights[i] - heights[i - 2]) + twoStep;

            twoStep = oneStep;
            oneStep = Math.min(onej, twoj);

        }

        return oneStep;
    }
}
