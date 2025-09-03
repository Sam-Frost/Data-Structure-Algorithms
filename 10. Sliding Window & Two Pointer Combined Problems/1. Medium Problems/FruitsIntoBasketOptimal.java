/*
 *  Time Complexity: O(N)
 *  Space Complexity: O(1)
 *  We use a sliding window approach with two pointers (left and right) to maintain a
 *  window of elements in the array.
 *  We use a HashMap to keep track of the count of each type of fruit in the current window.
 *  As we expand the window by moving the right pointer, we add the fruit at the right pointer
 *  to the HashMap and increment its count.
 *  If the size of the HashMap exceeds 2 (indicating more than two types` of fruits in the window),
 *  we move the left pointer to the right, decrementing the count of the fruit at the left pointer
 *  in the HashMap. If the count of that fruit becomes 0, we remove it from the HashMap.
 *  We keep track of the maximum number of fruits collected in any valid subarray and return that value at the end.
 */

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasketOptimal {
       public int totalFruits(int[] fruits) {

        int maxFruits = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            } else {
                maxFruits = Math.max(maxFruits, right - left + 1);
            }
            right++;
        }

        return maxFruits;
    }
}
