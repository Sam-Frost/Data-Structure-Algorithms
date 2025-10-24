/*
 * Time Complexity: O(N log N) due to modified merge sort
 * Space Complexity: O(N) for the temporary array used in merging
 * This code counts the number of reverse pairs in an array using a modified merge sort algorithm.
 * A reverse pair is defined as a pair of indices (i, j) such that i < j and nums[i] > 2 * nums[j].
 * The algorithm sorts the array while counting the reverse pairs during the merge step.
 * For example, given the array [1,3,2,3,1], the number of reverse pairs is 2: (3,1) and (3,1).
 */
import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    class Solution {

        int reversePairs = 0;

        public int reversePairs(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return reversePairs;
        }

        private void sort(int[] nums, int low, int high) {

            if (low >= high) {
                return;
            }

            int mid = (low + high) / 2;

            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            countPairs(nums, low, mid, high);
            merge(nums, low, mid, high);
        }

        private void countPairs(int[] nums, int low, int mid, int high) {
            int lastIndex = mid + 1;

            while (low <= mid) {
                while (lastIndex <= high && (long) nums[low] > 2L * nums[lastIndex]) {

                    lastIndex++;
                }

                this.reversePairs += (lastIndex - (mid + 1));

                low++;
            }
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

}
