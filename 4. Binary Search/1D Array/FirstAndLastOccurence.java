/*
 * Time Complexity: O(log N) for each of the first and last occurrence searches
 * Space Complexity: O(1) as no additional space is used
 * This code finds the first and last occurrence of a target value in a sorted array using binary search.
 * It defines two helper functions, firstOccurrence and lastOccurrence, to perform the searches.
 * For example, given the array [5,7,7,8,8,10] and target 8, the output will be [3,4].
 */
public class FirstAndLastOccurence {

    public int[] searchRange(int[] nums, int target) {

        return new int[]{firstOccurrence(nums, target), lastOccurrence(nums, target)};

    }

    public int firstOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int lastOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
