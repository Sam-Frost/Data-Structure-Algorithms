/*
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * This solution counts the frequency of each element in the input array using a HashMap.
 * It iterates through the array, updating the count for each element in the map.
 * After populating the map, it constructs a list of lists, where each inner list contains
 * an element and its corresponding frequency.
 * The final result is a list of these frequency pairs.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountFrequencyOfArrayElements {

    public List<List<Integer>> countFrequencies(int[] nums) {

        List<List<Integer>> frequencies = new ArrayList<>();

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Create Hash Map with frequencies
        for (int i = 0; i < nums.length; i++) {
            Integer num = freq.get(nums[i]);
            if (num == null) {
                freq.put(nums[i], 1);
            } else {
                freq.put(nums[i], num + 1);
            }
        }

        // Create Answer Array
        for (Integer key : freq.keySet()) {

            List<Integer> individualFreq = List.of(key, freq.get(key));
            frequencies.add(individualFreq);
        }

        return frequencies;

    }
}
