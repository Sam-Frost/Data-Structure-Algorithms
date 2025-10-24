
import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * This code implements the Merge Sort algorithm to sort an array of integers.
 * It recursively divides the array into halves, sorts each half, and then merges them back together
 * in sorted order.
 * For example, given an array [38, 27, 43, 3, 9, 82, 10], the output will be [3, 9, 10, 27, 38, 43, 82].   
 */
public class MergeSort {

    public int[] mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
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
