/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * This solution rotates an array to the left by one position.
 * It iteratively swaps each element with its next element, effectively shifting all elements to the left.
 * The first element moves to the end of the array after all swaps are completed.   
 */

public class LeftRotateArrayByOne {

    public void rotateArrayByOne(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            swap(nums, i);
        }

    }

    private void swap(int[] nums, int i) {
        int c = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = c;
    }
}
