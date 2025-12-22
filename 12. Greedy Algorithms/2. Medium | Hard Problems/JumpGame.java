/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class JumpGame {

    public boolean canJump(int[] nums) {

        int maxDistance = nums[0];
        int curr = 1;

        while (curr < nums.length) {

            if (curr > maxDistance) {
                return false;
            }

            maxDistance = Math.max(curr + nums[curr], maxDistance);

            curr++;

            if (maxDistance >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
