/* 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * This solution checks if an array is sorted in non-decreasing order.
 * It iterates through the array and compares each element with its previous element.
 * If it finds any element that is smaller than its predecessor, it returns false.
 * If the loop completes without finding such an element, it returns true, indicating the array is sorted.
 */

import java.util.ArrayList;

public class CheckIfArrayIsSorted {

    public boolean isSorted(ArrayList<Integer> nums) {

        if (nums.size() == 1) {
            return true;
        }

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) >= nums.get(i - 1)) {
                continue;
            }

            return false;
        }

        return true;
    }
}
