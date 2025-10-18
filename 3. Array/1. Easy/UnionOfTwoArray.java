/*
 * Time Complexity : O(m + n) where m and n are the lengths of the two input arrays.
 * Space Complexity : O(m + n) for storing the union elements in the ArrayList.
 * This solution finds the union of two sorted arrays.
 * It uses a two-pointer technique to traverse both arrays simultaneously.
 * When elements at both pointers are equal, it adds the element to the union list and moves both pointers forward.
 * If the element in the first array is smaller, it adds that element to the union list and moves the pointer in the first array forward.
 * If the element in the second array is smaller, it adds that element to the union list and moves the pointer in the second array forward.
 * The process continues until all elements from both arrays have been processed.
 * Finally, it converts the ArrayList to an array and returns it.   
 */
import java.util.ArrayList;

public class UnionOfTwoArray {

    public int[] unionArray(int[] nums1, int[] nums2) {

        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        int latestElement = -1;

        while (i < nums1.length && j < nums2.length) {

            if (union.size() != 0) {
                latestElement = union.get(union.size() - 1);
            }

            if (nums1[i] == nums2[j]) {
                if (latestElement != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                if (nums2[j] != latestElement) {
                    union.add(nums2[j]);
                }
                j++;
            } else {
                if (nums1[i] != latestElement) {
                    union.add(nums1[i]);
                }
                i++;
            }
        }

        if (nums2.length == j) {
            while (i < nums1.length) {

                if (union.size() != 0) {
                    latestElement = union.get(union.size() - 1);
                }

                if (latestElement != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
            }
        }

        if (nums1.length == i) {
            while (j < nums2.length) {

                if (union.size() != 0) {
                    latestElement = union.get(union.size() - 1);
                }

                if (latestElement != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;
            }
        }

        return union.stream().mapToInt(Integer::intValue).toArray();
    }
}
