/*
 * Time Complexity: O(N log M) where N is the number of piles and M is the maximum number of bananas in a pile
 * Space Complexity: O(1) as no additional space is used
 * This code finds the minimum eating speed Koko needs to eat all bananas within H hours.
 * It uses binary search to determine the optimal eating speed by checking if Koko can finish
 * all bananas at a given speed within the allowed time.
 * For example, given piles = [3,6,7,11] and H = 8, the minimum eating speed is 4.  
 */
public class KokoEatingBananas {

    public int minimumRateToEatBananas(int[] nums, int h) {

        int low = 1;
        int high = findLargestNumber(nums);

        while (low <= high) {

            int currentRate = (low + high) / 2;

            long hoursToConsume = 0;
            // Calculate hours to con sume for current rate
            for (int i = 0; i < nums.length; i++) {
                hoursToConsume += nums[i] / currentRate;

                // Incase partial consumption, idle for rest of the hour
                if (nums[i] % currentRate > 0) {
                    hoursToConsume++;
                }
            }

            if (hoursToConsume > h) {
                low = currentRate + 1;
            } else if (hoursToConsume <= h) {
                high = currentRate - 1;
            }
        }

        return low;
    }

    private int findLargestNumber(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        return max;
    }
}
