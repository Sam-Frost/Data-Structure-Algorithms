/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * This solution finds the single number in an array where every other number appears twice.
 * It uses the XOR bitwise operation to achieve this.
 * The property of XOR states that a number XORed with itself results in 0, and a number XORed with 0 results in the number itself.
 * By XORing all the numbers in the array, the duplicate numbers cancel each other out, leaving only the single number.
 */
public class SingleNumberI {

    public int singleNumber(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
