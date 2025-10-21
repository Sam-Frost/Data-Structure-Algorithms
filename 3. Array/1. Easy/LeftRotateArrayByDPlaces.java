
/*
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 * This code rotates an array to the left by 'k' places.
 * It first reverses the first 'k' elements, then reverses the remaining elements,
 * and finally reverses the entire array to achieve the desired rotation.
 * For example, given an array [1, 2, 3, 4, 5] and k = 2, the output will be [3, 4, 5, 1, 2].
 */
public class LeftRotateArrayByDPlaces {

    public void rotateArray(int[] nums, int k) {

        if (k > nums.length) {
            k = k % nums.length;
        }

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
