/*
 * Time Complexity: O(2^n) where n is the number of elements in the input array
 * Space Complexity: O(n) for recursive stack space
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    public void solve(int[] nums, List<Integer> curr, List<List<Integer>> ans, int index) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Selection
        curr.add(nums[index]);
        solve(nums, curr, ans, index + 1);
        curr.remove(curr.size() - 1);

        // Without Selection
        int tempIndex = index;
        while (tempIndex + 1 < nums.length && nums[tempIndex] == nums[tempIndex + 1]) {
            tempIndex++;
        }
        solve(nums, curr, ans, tempIndex + 1);
    }
}
