/*
 * Time Complexity: O(log N) where N is the number of elements in the array
 * Space Complexity: O(1)
 * This code finds the upper bound index of a given element 'x' in a sorted array.
 * The upper bound is defined as the index of the first element that is greater than 'x'.
 * If all elements in the array are less than or equal to 'x', it returns the   length of the array.
 * For example, given the sorted array [1, 2, 4, 4, 5] and x = 4, the upper bound index will be 4.      
 */
public class UpperBound {

    public int upperBound(int[] nums, int x) {

        int ceil = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] <= x) {
                low = mid + 1;
            } else if (nums[mid] > x) {
                ceil = mid;
                high = mid - 1;
            }
        }
        return ceil;
    }
}
