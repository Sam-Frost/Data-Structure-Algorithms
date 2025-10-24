/*
 * Time Complexity: O(N log N) due to merge sort
 * Space Complexity: O(N) for the temporary array used in merging
 * This code counts the number of inversions in an array using a modified merge sort algorithm.
 * An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j].
 * The algorithm sorts the array while counting the inversions during the merge step.
 * For example, given the array [2, 4, 1, 3, 5], the number of inversions is 3: (2,1), (4,1), (4,3).
 */
import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    private long numberOfInversions = 0;

    public long numberOfInversions(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return numberOfInversions;
    }

    private void sort(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
                this.numberOfInversions += mid - left + 1;
            }

        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

    }
}
