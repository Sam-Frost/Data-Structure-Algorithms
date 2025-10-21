/*
 * Time Complexity: O(N log N) due to sorting
 * Space Complexity: O(N) for the merge sort auxiliary space
 * This code finds the length of the longest consecutive elements sequence in an unsorted array.
 * It first sorts the array using merge sort and then iterates through the sorted array
 * to count the length of consecutive sequences.
 * For example, given the array [100, 4, 200, 1, 3, 2], the longest consecutive sequence is [1, 2, 3, 4],
 * and the output will be 4.
 */
public class LongestConseucitveSubSequenceInArray {

    public int longestConsecutive(int[] nums) {

        int maxCount = 1;
        int currCount = 1;

        mergeSort(nums, 0, nums.length - 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currCount++;
            } else if (nums[i] > nums[i - 1] + 1) {
                currCount = 1;
            }

            maxCount = Math.max(currCount, maxCount);
        }

        return maxCount;
    }

    // ------------------- MERGE SORT -------------------
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge the two halves
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}
