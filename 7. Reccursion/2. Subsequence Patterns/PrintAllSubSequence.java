
import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequence {

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        generate(0, new ArrayList<>(), ans, nums);

        return ans;
    }

    public void generate(int index, List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        generate(index + 1, curr, ans, nums);
        curr.remove(curr.size() - 1);

        generate(index + 1, curr, ans, nums);
    }
}
