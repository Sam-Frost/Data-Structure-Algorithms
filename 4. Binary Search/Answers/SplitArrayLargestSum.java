/*
 * Time Complexity: O(N log S) where N is number of elements in array and S is the sum of all elements
 * Space Complexity: O(1)   
 */
public class SplitArrayLargestSum {

    public int largestSubarraySumMinimized(int[] a, int k) {

        int low = getMaxValue(a);
        int high = getTotalSum(a);

        while (low <= high) {
            int maxSum = (low + high) / 2;

            if (getMaxPossibleSubArray(a, maxSum) > k) {
                low = maxSum + 1;
            } else {
                high = maxSum - 1;
            }
        }
        return low;
    }

    private int getMaxPossibleSubArray(int[] a, int maxSum) {
        int maxSubArray = 1;
        int currSum = 0;

        for (int i = 0; i < a.length; i++) {

            if (currSum + a[i] <= maxSum) {
                currSum += a[i];
            } else {

                maxSubArray++;
                currSum = a[i];
            }
        }

        return maxSubArray;
    }

    private int getMaxValue(int[] a) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }

        return max;
    }

    private int getTotalSum(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
