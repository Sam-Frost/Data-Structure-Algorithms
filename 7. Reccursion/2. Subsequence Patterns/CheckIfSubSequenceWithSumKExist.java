/*
 * Time Complexity: O(2^n) where n is the number of elements in the array
 * Space Complexity: O(n) for recursive stack space
 */
public class CheckIfSubSequenceWithSumKExist {

    public boolean checkSubsequenceSum(int[] nums, int k) {
        return generate(0, 0, nums, k);
    }

    public boolean generate(int index, int currSum, int[] nums, int k) {
        if (k == 0) {
            return true;
        }

        if (k < 0) {
            return false;
        }

        if (index == nums.length) {
            return false;
        }

        boolean with = generate(index + 1, currSum + nums[index], nums, k - nums[index]);
        boolean without = generate(index + 1, currSum, nums, k);

        return with || without;
    }
}
