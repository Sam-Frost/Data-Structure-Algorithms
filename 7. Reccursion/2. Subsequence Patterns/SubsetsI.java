/*
 * Time Complexity: O(2^n) where n is the number of elements in the input array
 * Space Complexity: O(n) for recursive stack space
 */
import java.util.ArrayList;
import java.util.List;

public class SubsetsI {

    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        subset(nums, 0, ans, 0);
        return ans;
    }

    private void subset(int[] nums, int currSum, List<Integer> ans, int index) {

        if (index == nums.length) {
            ans.add(currSum);
            return;
        }

        // Selection
        subset(nums, currSum + nums[index], ans, index + 1);
        // No Selection
        subset(nums, currSum, ans, index + 1);
    }

    // public List<Integer> subsetSums(int[] nums) {
    //   List<Integer> ans = new ArrayList<>();
    //   ans.add(0);
    //   subset(nums, 0, new ArrayList<>(), ans, 0);
    //   return ans;
    // }
    // private void subset(int[] nums, int currSum, List<Integer> curr, List<Integer> ans, int index) {
    //   if (index >= nums.length) {
    //     return;
    //   } 
    //   // Selection
    //   curr.add(nums[index]);
    //   currSum += nums[index];
    //   ans.add(currSum);
    //   subset(nums, currSum, curr, ans, index + 1);
    //   currSum -= nums[index];
    //   curr.remove(curr.size() - 1);
    //   subset(nums, currSum, curr, ans, index + 1);
    // }
}
