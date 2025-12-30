/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LargestElementInAnArray {

    public int largestElement(int[] nums) {
        int largest = nums[0]; // start with first element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }
}
