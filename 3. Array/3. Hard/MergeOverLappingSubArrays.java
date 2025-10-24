/*
 * Time Comlexity : O(N log N) due to sorting
 * Space Complexity: O(N) for the output list
 * This code merges overlapping subarrays from a list of intervals.
 * It first sorts the intervals based on their starting values and then iterates through them,
 * merging any overlapping intervals into a single interval.
 * For example, given the intervals [[1,3],[2,4],[5,7],[6,8]], the output will be [[1,4],[5,8]].    
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingSubArrays {

    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {

        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<List<Integer>> finalIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {

            if (finalIntervals.isEmpty()) {
                finalIntervals.add(intervals.get(i));
            } else {
                if (intervals.get(i - 1).get(1) >= intervals.get(i).get(0)) {
                    int startInterval = intervals.get(i - 1).get(0);
                    finalIntervals.remove(finalIntervals.size() - 1);
                    finalIntervals.add(Arrays.asList(startInterval, intervals.get(i).get(1)));
                } else {
                    finalIntervals.add(intervals.get(i));
                }
            }
        }

        return finalIntervals;
    }
}
