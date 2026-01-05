/*
 Time Complexity: O(n)
 Space Complexity: O(1)
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        int element = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (count == 0) {
                element = nums[i];
            }

            if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}
