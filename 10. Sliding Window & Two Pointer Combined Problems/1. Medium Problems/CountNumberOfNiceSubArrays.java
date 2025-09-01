/*
 *  Time Complexity: O(N)
 * Space Complexity: O(1)
 *  Same question as BinarySubArrayWithSumOptimal.java
 * We use a sliding window approach with two pointers (left and right) to maintain a
 * window of elements in the array.
 * We maintain a running sum of the odd elements in the current window.
 * As we expand the window by moving the right pointer, we add 1 to the running sum if the element at the right pointer is odd (nums[r] % 2).
 * If the running sum exceeds the goal (k), we move the left pointer to the right, subtracting
 * 1 from the running sum if the element at the left pointer is odd (nums[l] % 2) until the sum is less than or equal to the goal.
 * We count the number of subarrays that end at the right pointer and have a sum equal
 * to the goal by adding the length of the current window (calculated as r - l + 1) to the count variable.
 * This is because all subarrays that start from any index between l and r (inclusive)
 * and end at r will have a sum equal to the goal.
 * We repeat this process until the right pointer reaches the end of the array.
 * To find the number of subarrays with a sum exactly equal to the goal, we
 * calculate the difference between the number of subarrays with a sum less than or equal to the
 * goal and the number of subarrays with a sum less than or equal to goal - 1.
 * This approach ensures that we traverse the array only once, resulting in a linear time complexity.
 * The space complexity is constant since we are using only a fixed number of variables.
 * This approach is efficient and works well for arrays where we need to count subarrays based on
 * the number of odd elements.
 * 
 */

public class CountNumberOfNiceSubArrays {
  
    public int numberOfOddSubarrays(int[] nums, int k) {
        return sum(nums, k) - sum(nums, k-1);
    }

    private int sum(int[] nums, int goal){

        if(goal < 0)
            return 0;

        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        while( r < nums.length){
            
            sum += nums[r] % 2;

            while(sum > goal){
                sum -= nums[l] % 2;
                l++;
            }

            count += r - l + 1;
            r++;
        }   

        return count;
    }

}
