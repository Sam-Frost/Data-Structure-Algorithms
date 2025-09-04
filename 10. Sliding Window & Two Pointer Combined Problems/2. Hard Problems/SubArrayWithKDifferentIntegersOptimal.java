
/*
 *  Time Complexity: O(2N)
 *  Space Complexity: O(1)
 *  We use a sliding window approach with two pointers (left and right) to maintain a
 *  window of elements in the array.
 *  We use a HashMap to keep track of the count of each integer in the current window.
 *  As we expand the window by moving the right pointer, we add the integer at the right pointer
 *  to the HashMap and increment its count.
 *  If the size of the HashMap exceeds k (indicating more than k distinct integers in the window),
 *  we move the left pointer to the right, decrementing the count of the integer at the left pointer
 *  in the HashMap. If the count of that integer becomes 0, we remove it from the HashMap.
 *  We calculate the number of valid subarrays ending at each position by adding (right - left + 1)
 *  to our result for each position of the right pointer.
 */

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntegersOptimal {
    public int subarraysWithKDistinct(int[] nums, int k) {

        return subarraysWithLessThanEqualKDistinct(nums, k)
                - subarraysWithLessThanEqualKDistinct(nums, k - 1);
    }

    private int subarraysWithLessThanEqualKDistinct(int[] nums, int k) {

        if (k == 0)
            return 0;
        int l = 0;
        int r = 0;
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (r < nums.length) {

            // Put into hashMap the increased value
            hashMap.put(nums[r], hashMap.getOrDefault(nums[r], 0) + 1);

            while (hashMap.size() > k) {

                int val = hashMap.get(nums[l]);
                hashMap.put(nums[l], val - 1);

                if (val - 1 == 0)
                    hashMap.remove(nums[l]);

                l++;
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }

}
