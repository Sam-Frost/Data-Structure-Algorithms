/*
 * Time Complexity: O(log N) where N is the number of elements in the array
 * Space Complexity: O(1)
 * This code finds the floor and ceiling of a given element 'x' in a sorted array.
 * The floor is defined as the greatest element less than or equal to 'x',
 * and the ceiling is defined as the smallest element greater than or equal to 'x'.
 * If such elements do not exist, it returns -1 for that value.
 * For example, given the sorted array [1, 2, 4, 6
 */
public class FloorAndCeilInSortedArray {

    public int[] getFloorAndCeil(int[] nums, int x) {

        int low = 0;
        int high = nums.length - 1;

        int floor = -1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == x) {
                return new int[]{x, x};
            } else if (x > nums[mid]) {
                low = mid + 1;
                floor = nums[mid];
            } else {
                high = mid - 1;
                ceil = nums[mid];
            }
        }

        return new int[]{floor, ceil};
    }
}
