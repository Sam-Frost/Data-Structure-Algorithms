/*
 * Time Complexity: O(NlogN) + O(N*M) where N is number of jobs and M is maximum deadline
 * Space Complexity: O(M) for timeline array
 */
import java.util.Arrays;

public class JobSequencingProblem {

    public int[] JobScheduling(int[][] Jobs) {

        int maxDeadline = 0;
        int numberOfJobs = 0;
        int maxProfit = 0;

        for (int i = 0; i < Jobs.length; i++) {
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }

        int[] timeline = new int[maxDeadline + 1];
        Arrays.fill(timeline, -1);

        Arrays.sort(Jobs, (a, b) -> b[b.length - 1] - a[a.length - 1]);

        for (int i = 0; i < Jobs.length; i++) {

            int currJobDeadline = Jobs[i][1];

            while (currJobDeadline > 0) {
                if (timeline[currJobDeadline] == -1) {
                    maxProfit += Jobs[i][2];
                    timeline[currJobDeadline] = Jobs[i][1];
                    numberOfJobs++;
                    break;
                }
                currJobDeadline--;
            }

        }

        return new int[]{numberOfJobs, maxProfit};
    }
}
