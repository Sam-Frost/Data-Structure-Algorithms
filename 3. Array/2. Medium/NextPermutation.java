/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This code finds the next lexicographical permutation of a given array of integers.
 * It first identifies a pivot point where the sequence starts decreasing,
 * then swaps it with the smallest element greater than the pivot from the right side,
 * and finally reverses the sequence after the pivot to get the next permutation.
 * For example, given the array [1, 2, 3], the next permutation will be [1, 3, 2].
 */

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int index = -1;

        // Find Pivot Point
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // If no pivot, reverse the array
        if (index == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - 1 - i);
            }
            return;
        }

        // Swap the pivot element with the smallest available but greater than pivot
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
                break;
            }
        }

        int left = index + 1;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
