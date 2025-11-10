/*
 * Time Complexity: O(2^n * k) where n is the number of candidates and k is the average length of each combination
 * Space Complexity: O(k) for recursive stack space
 */
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr, int index) {

        // Found correct sub sequence
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Length too large
        if (target < 0) {
            return;
        }

        // Ran out of candidates
        if (index >= candidates.length) {
            return;
        }

        // No selection
        solve(candidates, target, ans, curr, index + 1);

        curr.add(candidates[index]);
        // Selection with same index
        solve(candidates, target - candidates[index], ans, curr, index);

        curr.remove(curr.size() - 1);

    }
}
