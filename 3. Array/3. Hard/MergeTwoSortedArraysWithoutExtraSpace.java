/*
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 * This code merges two sorted arrays, nums1 and nums2, into nums1 without using extra space.
 * It starts from the end of both arrays and places the larger element at the end of nums1,
 * effectively merging the two arrays in a single pass.
 * For example, given nums1 = [1, 3, 5, 0, 0, 0] with m = 3 and nums2 = [2, 4, 6] with n = 3,
 * the output will be nums1 = [1, 2, 3, 4, 5, 6].
 */
public class MergeTwoSortedArraysWithoutExtraSpace {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int ind = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[ind] = nums1[i];
                i--;
            } else {
                nums1[ind] = nums2[j];
                j--;
            }
            ind--;
        }

    }
}
