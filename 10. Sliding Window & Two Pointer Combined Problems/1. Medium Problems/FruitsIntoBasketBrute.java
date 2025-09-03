/*
 *  Time Complexity: O(n^2)
 *  Space Complexity: O(1)
 *  We use a brute-force approach with two nested loops to explore all possible subarrays of the input array.
 *  The outer loop iterates through each element of the array as a potential starting point for a subarray.
 *  The inner loop extends the subarray from the starting point and uses a HashSet to track the unique fruit types encountered.
 *  If the size of the HashSet exceeds 2, we break out of the inner loop as we can only have two types of fruits in the baskets.
 *  We keep track of the maximum number of fruits collected in any valid subarray and return that value at the end.
 */

import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBasketBrute {
     public int totalFruits(int[] fruits) {

        int maxFruits = 0;

        for(int i = 0; i < fruits.length; i++){

            Set<Integer> set = new HashSet<>();
            int currSize = 0;
            for(int j = i; j < fruits.length; j++){
                set.add(fruits[j]);
                currSize++;
                if(set.size() > 2) {
                    break;
                } else {
                   maxFruits = Math.max(currSize, maxFruits); 
                }
            }
        }

        return maxFruits;
    }
}
