/*
 *  Time Complexity: O(N^2)
 *  Space Complexity: O(1)
 *  We use a brute-force approach with two nested loops to find all subarrays in the given binary array.
 *  The outer loop iterates through each element in the array, treating it as the starting point of a subarray.
 *  The inner loop iterates from the current starting point to the end of the array, calculating the sum of the subarray as it expands. 
 */

public class BinarySubArrayWithSumBrute {
     public int numSubarraysWithSum(int[] nums, int goal) {

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == goal)
                    ans++;
            }
        }

        return ans;
    }
}
