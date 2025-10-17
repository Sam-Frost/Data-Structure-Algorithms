/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * This solution rearranges the input array such that positive and negative numbers alternate.
 * It first separates the positive and negative numbers into two different arrays.
 * Then, it merges these two arrays back into the original array in an alternating fashion.
 * The approach assumes that the input array contains an equal number of positive and negative numbers.
 */

public class RearrangeArrayInAlternatingPositiveAndNegativeItems {

    public int[] rearrangeArray(int[] nums) {

        int[] nNums = new int[nums.length / 2];
        int[] pNums = new int[nums.length / 2];

        int nIndex = 0;
        int pIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pNums[pIndex] = nums[i];
                pIndex++;
            } else {
                nNums[nIndex] = nums[i];
                nIndex++;
            }
        }

        boolean isPositiveTurn = true;

        nIndex = 0;
        pIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isPositiveTurn) {
                nums[i] = pNums[pIndex];
                pIndex++;
            } else {
                nums[i] = nNums[nIndex];
                nIndex++;
            }
            isPositiveTurn = !isPositiveTurn;
        }

        return nums;
    }
}
