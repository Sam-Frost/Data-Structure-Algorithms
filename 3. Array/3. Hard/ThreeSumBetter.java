/*
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumBetter {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {

            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {

                int thirdNumber = -(nums[i] + nums[j]);

                if (set.contains(thirdNumber)) {
                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(thirdNumber);

                    Collections.sort(temp);
                    ans.add(temp);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList(ans);
    }
}
