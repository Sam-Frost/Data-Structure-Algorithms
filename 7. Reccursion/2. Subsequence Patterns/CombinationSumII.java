/*
 * Time Complexity: O(2^n) where n is the number of candidates
 * Space Complexity: O(n) for recursive stack space
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void combination(
            int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr, int index) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) {
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        // Without Selection
        int tempIndex = index;

        while (tempIndex < candidates.length - 1
                && candidates[tempIndex] == candidates[tempIndex + 1]) {
            tempIndex++;
        }

        combination(candidates, target, ans, curr, tempIndex + 1);

        // With Selection
        curr.add(candidates[index]);
        combination(candidates, target - candidates[index], ans, curr, index + 1);
        curr.remove(curr.size() - 1);
    }
}
