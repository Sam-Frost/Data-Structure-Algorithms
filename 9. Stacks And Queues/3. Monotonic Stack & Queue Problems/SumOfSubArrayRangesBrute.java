/*
 *  Time Complexity: O(n^2)
 *  Space Complexity: O(1)
 *  This brute force solution iterates through all subarrays, calculating the maximum and minimum for each subarray.
 *  It sums the differences between the maximum and minimum values for each subarray.
 */

public class SumOfSubArrayRangesBrute {
     public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i+1; j < nums.length; j++){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
}
