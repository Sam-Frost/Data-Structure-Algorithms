/*

Sum of First N Natural Number - Sum of numbers in the array
 */
public class FindMissingNumber {

    public int missingNumber(int[] nums) {

        int sumOfNumbers = (nums.length * (nums.length + 1)) / 2;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sumOfNumbers - sum;

    }
}
