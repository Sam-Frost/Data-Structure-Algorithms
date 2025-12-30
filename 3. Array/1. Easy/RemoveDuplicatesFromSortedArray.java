/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int uniqueElements = 1;

        int lastUniqueElement = nums[0];
        int swapIndex = 1;

        int i = 1;

        while (i < nums.length) {

            if (nums[i] != lastUniqueElement) {
                lastUniqueElement = nums[i];
                swap(nums, i, swapIndex);
                uniqueElements++;
                swapIndex++;
            }
            i++;
        }

        return uniqueElements;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
