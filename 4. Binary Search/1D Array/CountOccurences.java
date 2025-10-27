/*
 * Time Complexity: O(log N) for each occurrence search
 * Space Complexity: O(1) as no additional space is used
 * This code counts the number of occurrences of a target value in a sorted array using binary search.
 * It defines two helper functions, firstOccurrence and lastOccurrence, to find the first and last
 * positions of the target value. The count is then calculated as the difference between these two
 * positions plus one.
 * For example, given the array [5,7,7,8,8,10] and target 8, the output will be 2.
 */
public class CountOccurences {

    public int countOccurrences(int[] arr, int target) {

        int lastOccurrence = lastOccurrence(arr, target);
        int firstOccurrence = firstOccurrence(arr, target);

        if (firstOccurrence == -1 && lastOccurrence == -1) {
            return 0;
        }

        if (firstOccurrence == -1 || lastOccurrence == -1) {
            return 1;
        }

        return lastOccurrence - firstOccurrence + 1;
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
