/*
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * This solution finds all the leaders in an array.
 * An element is considered a leader if it is greater than all the elements to its right.
 * The algorithm iterates through the array from right to left, keeping track of the largest element seen so far.
 * Whenever it encounters an element greater than the current largest element, it adds that element to the list of leaders and updates the largest element.
 * Finally, it reverses the list of leaders to maintain the original order and returns it.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInAnArray {

    public List<Integer> leaders(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        int largestElement = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > largestElement) {
                list.add(nums[i]);
                largestElement = nums[i];
            }
        }

        Collections.reverse(list);

        return list;
    }
}
