/*
 * Time Complexity: O(N log S) where N is number of boards and S is the sum of all board lengths
 * Space Complexity: O(1)       
 */
public class PaintersPartition {

    public int paint(int A, int B, int[] C) {

        long low = getMaxValue(C);
        long high = getTotalSum(C);

        while (low <= high) {
            long maxSum = (low + high) / 2;

            if (getMaxPossibleSubArray(C, maxSum) > A) {
                low = maxSum + 1;
            } else {
                high = maxSum - 1;
            }
        }
        return (int) ((low * B) % 10000003);
    }

    private int getMaxPossibleSubArray(int[] a, long maxSum) {
        int maxSubArray = 1;
        long currSum = 0;

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
