/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This solution moves all zeros in the array to the end while maintaining the relative order of non-zero elements.
 * It uses two pointers: one (i) to traverse the array and another (numIndex) to find the next non-zero element.
 * When a zero is encountered at index i, the inner loop advances numIndex to find the next non-zero element and swaps it with the zero at index i.
 * This process continues until all elements in the array have been processed.
 */
public class MoveZerosToEnd {

    public void moveZeroes(int[] nums) {

        int numIndex = 0;
        int i = 0;

        while (i < nums.length && numIndex < nums.length) {

            if (numIndex < i) {
                numIndex = i;
            }

            if (nums[i] == 0) {
                while (numIndex < nums.length - 1 && nums[numIndex] == 0) {
                    numIndex++;
                }
                swap(nums, i, numIndex);
            }
            i++;

        }
    }

    private void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}
