/*
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 * This code finds the maximum product of a contiguous subarray within an integer array.
 * It maintains two variables to track the maximum and minimum products up to the current position,
 * as negative numbers can turn a minimum product into a maximum when multiplied.
 * The algorithm iterates through the array, updating these variables and the overall maximum product found.
 * For example, given the array [2,3,-2,4], the maximum product subarray is [2,3] with a product of 6.  
 */
public class MaximumProductSubArrayInAnArray {

    public int maxProduct(int[] nums) {

        int prefixProduct = 1;
        int suffixProduct = 1;
        int ans = Integer.MIN_VALUE;

        // Prefix Product
        for (int i = 0; i < nums.length; i++) {

            if (prefixProduct == 0) {
                prefixProduct = 1;
            }

            if (suffixProduct == 0) {
                suffixProduct = 1;
            }

            prefixProduct = prefixProduct * nums[i];
            suffixProduct = suffixProduct * nums[nums.length - 1 - i];

            ans = Math.max(ans, Math.max(prefixProduct, suffixProduct));
        }

        return ans;
    }
}
