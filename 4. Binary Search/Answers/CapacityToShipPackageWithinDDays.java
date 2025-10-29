/*
 * Time Complexity: O(N log M) where N is number of weights and M is the range between max weight and total weight
 * Space Complexity: O(1)
 * 
 */
public class CapacityToShipPackageWithinDDays {

    public int shipWithinDays(int[] weights, int days) {

        int low = findMaxWeight(weights);
        int high = findTotalWeight(weights);

        while (low <= high) {
            int capacity = (low + high) / 2;
            int numberOfDays = getNumberOfDays(weights, capacity);

            if (numberOfDays > days) {
                low = capacity + 1;
            } else {
                high = capacity - 1;
            }
        }

        return low;
    }

    int getNumberOfDays(int[] weights, int capacity) {

        int numOfDays = 0;
        int currWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            // Increase current weight if under capacity
            if (currWeight + weights[i] <= capacity) {
                currWeight += weights[i];
            } else {
                // If Over Capacity
                numOfDays++;
                currWeight = 0;
                currWeight += weights[i];
            }
        }

        return numOfDays + 1;
    }

    int findTotalWeight(int[] weights) {
        int max = 0;

        for (int i = 0; i < weights.length; i++) {
            max += weights[i];
        }

        return max;
    }

    int findMaxWeight(int[] weights) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
        }

        return max;
    }
}
