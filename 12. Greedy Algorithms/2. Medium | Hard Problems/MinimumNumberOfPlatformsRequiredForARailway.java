/*
 * Time Complexity: O(NlogN) where N is the number of trains
 * Space Complexity: O(1)
 */
import java.util.Arrays;

public class MinimumNumberOfPlatformsRequiredForARailway {

    public int findPlatform(int[] Arrival, int[] Departure) {

        int i = 0;
        int j = 0;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int currCount = 0;
        int maxCount = 0;

        while (i < Arrival.length && j < Departure.length) {
            if (Arrival[i] <= Departure[j]) {
                currCount++;
                i++;
            } else {
                currCount--;
                j++;
            }

            maxCount = Math.max(currCount, maxCount);
        }

        return maxCount;
    }
}
