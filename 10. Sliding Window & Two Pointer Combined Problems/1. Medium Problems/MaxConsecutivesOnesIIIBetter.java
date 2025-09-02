/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * We use a sliding window approach with two pointers (left and right) to maintain a
 * window of elements in the array.
 * We maintain a count of the number of 0s in the current window.
 * As we expand the window by moving the right pointer, we increment the count if the
 * element at the right pointer is 0.
 * If the count exceeds k, we move the left pointer to the right, decrementing the count
 * if the element at the left pointer is 0 until the count is less than or equal to k.
 * We keep track of the maximum length of valid windows encountered during this process.
 */
public class MaxConsecutivesOnesIIIBetter {
        public int longestOnes(int[] nums, int k) {
        int length = 0;
        int r = 0;
        int l = 0;
        int counter = 0;

        while(r < nums.length){

            if(nums[r] == 0){
                counter++;
            }

            while(counter > k){
                if(nums[l] == 0)
                    counter--;
                l++;
            }

            length = Math.max(length, r -  l + 1);
            r++;
        }

        return length;
    }
}
