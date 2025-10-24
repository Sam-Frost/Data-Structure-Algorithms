/*
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * This code finds the length of the largest subarray with a sum of zero in a given integer array.
 * It uses a HashMap to store the prefix sums and their corresponding indices while iterating through the array.
 * If a prefix sum repeats, it indicates that the elements between the two indices sum to zero,
 * and the length of this subarray is calculated and compared to the maximum length found so far.
 * For example, given the array [1, -1, 3, 2, -2, -3, 3], the largest subarray with sum zero is [3, 2, -2, -3],
 * and the output will be 4.
 */
import java.util.HashMap;

public class LargestSubArrayWithSum0 {

    public int maxLen(int[] arr) {

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int currSum = 0;

        prefixSumMap.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            currSum += arr[i];

            Integer existingCurrSumIndex = prefixSumMap.get(currSum);

            if (existingCurrSumIndex != null) {
                maxLength = Math.max(maxLength, i - existingCurrSumIndex);
            } else {
                prefixSumMap.put(currSum, i);
            }

        }

        return maxLength;
    }
}
