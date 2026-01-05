
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSumBrute(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] solutionArray = {i, j};
                    return solutionArray;
                }
            }
        }

        return new int[]{-1, -1};

    }

    public int[] twoSumBetter(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int value = target - nums[i];

            if (hashMap.get(value) != null) {
                return new int[]{i, hashMap.get(value)};
            }

            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }
}
