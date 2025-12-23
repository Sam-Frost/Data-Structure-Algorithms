/*
 * Time Complexity: O(NlogN) where N is the number of processes
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class ProgramForShortestJobFirstCPUScheduling {

    public long solve(int[] bt) {

        if (bt.length == 1) {
            return 0;
        }

        Arrays.sort(bt);

        long currTime = 0;
        long totalWeightTime = 0;

        for (int i = 0; i < bt.length; i++) {
            totalWeightTime += currTime;
            currTime += bt[i];
        }

        return totalWeightTime / (bt.length);
    }

}
