/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This solution finds the missing number in an array containing n distinct numbers
 * taken from the range 0 to n. It calculates the expected sum of the first n natural numbers
 * using the formula n*(n+1)/2 and subtracts the sum of the numbers present in the array from it.
 * The result is the missing number.
 */
public class FindMissingNumberInArray {

    public int missingNumber(int[] nums) {

        int presentSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            presentSum += nums[i];
        }

        return (n * (n + 1) / 2) - presentSum;
    }
}
