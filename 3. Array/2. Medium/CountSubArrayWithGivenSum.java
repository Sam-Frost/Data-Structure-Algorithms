/*
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 * This code counts the number of continuous subarrays in an integer array that sum up to a given value 'k'.
 * It uses a HashMap to store the frequency of prefix sums encountered while iterating through the array.
 * For each element, it calculates the current prefix sum and checks if there exists a prefix sum that, when subtracted from the current prefix sum, equals 'k'.
 */
import java.util.HashMap;

public class CountSubArrayWithGivenSum {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        prefixSumCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            if (prefixSumCount.get(prefixSum - k) != null) {
                count += prefixSumCount.get(prefixSum - k);
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);

        }

        return count;

    }
}
