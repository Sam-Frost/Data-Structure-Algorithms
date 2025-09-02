/*
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * We use a brute-force approach with two nested loops to find the longest subarray of
 * 1s that can be formed by flipping at most k 0s.
 * The outer loop iterates through each element in the array as a potential starting point
 * for a subarray.
 * The inner loop expands the subarray by moving the end pointer to the right, counting the
 * number of 0s encountered.
 * If the count of 0s exceeds k, we break out of the inner loop.
 * We keep track of the maximum length of valid subarrays encountered during this process.
 */
public class MaxConsecutivesOnesIIIBrute {
    public int longestOnes(int[] nums, int k) {
        int length = 0;


        for(int i = 0; i < nums.length; i++){
            int count = 0;

            for(int j = i; j < nums.length;  j++){
                if( nums[j] == 0){
                    count++;
                }

                if(count > k)
                 break;

                length = Math.max(length, j-i+1);
               
            }
        }

        return length;
    }
}
