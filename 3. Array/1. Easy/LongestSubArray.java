
import java.util.HashMap;
import java.util.Map;

public class LongestSubArray {

    // Best Solution if array has +ve, 0 and -ve
    public int longestSubArray(int[] arr, int k) {

        Map<Integer, Integer> preSumMap = new HashMap<>();

        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            int remain = sum - k;

            Integer val = preSumMap.get(remain);

            if (val != null) {
                maxLength = Math.max(maxLength, i - val);
            }

            if (preSumMap.get(sum) == null) {
                preSumMap.put(sum, i);
            }

        }

        return maxLength;

    }

    // Best Solution if array has only +ve
    public int longestSubArrayPositive(int[] arr, int k) {

        int maxLength = 0;
        int sum = arr[0];
        int low = 0;
        int high = 0;

        while (high < arr.length) {
            while (sum > k) {
                sum -= arr[low];
                low--;
            }

            high++;
            if (high < arr.length) {
                sum = +arr[high];
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, high - low + 1);
            }

        }

        return maxLength;

    }
}
