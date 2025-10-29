/*
 * Time Complexity: O(N log M) where N is number of stalls and M is the range between min and max stall positions
 * Space Complexity: O(1)
 */
import java.util.Arrays;

public class AggresiveCows {

    public int aggressiveCows(int[] nums, int k) {

        Arrays.sort(nums);

        int low = 1;
        int high = getHigh(nums);

        while (low <= high) {

            int minimumDistance = (low + high) / 2;
            int numberOfCowsPlaced = numberOfCowsPlaced(nums, minimumDistance);
            if (numberOfCowsPlaced >= k) {
                low = minimumDistance + 1;
            } else {
                high = minimumDistance - 1;
            }
        }
        return low - 1;
    }

    private int numberOfCowsPlaced(int[] nums, int minimumDistance) {
        int cowsPlaced = 1;
        int lastCowPlaced = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[lastCowPlaced] >= minimumDistance) {
                cowsPlaced++;
                lastCowPlaced = i;
            }
        }

        return cowsPlaced;
    }

    private int getHigh(int[] nums) {
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }
        return high;
    }
}
