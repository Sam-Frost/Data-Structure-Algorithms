/*
 * Time Complexity : O(n) 
 * Space Complexity : O(1)
 */

public class MaximumSumOfNonAdjacentElementsTabulationSpaceOptimization {

    public int nonAdjacent(int[] nums) {
        int prevPrev = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + prevPrev;
            int notPick = 0 + prev;

            prevPrev = prev;
            prev = Math.max(pick, notPick);
        }

        return prev;
    }
}
