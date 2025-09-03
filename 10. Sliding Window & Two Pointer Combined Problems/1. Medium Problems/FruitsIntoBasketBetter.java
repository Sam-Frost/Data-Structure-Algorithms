/*
 *  Time Complexity: O(2N)
 *  Space Complexity: O(1)
 *  We use a sliding window approach with two pointers (left and right) to maintain a window of fruits.
 *  We also use a hashMap to store the count of each type of fruit in the current window.
 *  As we expand the window by moving the right pointer, we add the fruit at the right pointer to the hashMap and increment its count.
 *  If the size of the hashMap exceeds 2, we move the left pointer to the right, decrementing the count of the fruit at the left pointer in the hashMap.
 *  If the count of that fruit becomes 0, we remove it from the hashMap.
 *  We calculate the length of the current window and update the maxFruits variable if the current length is greater than the maxFruits.
 *  This approach ensures that we traverse the array only once, resulting in a linear time complexity.
 *  The space complexity is constant since the hashMap size is fixed (at most 3 for the two types of fruits and one extra).
 */

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasketBetter {
       public int totalFruits(int[] fruits) {

        int maxFruits = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }

            if(map.size() <= 2){
                maxFruits = Math.max(maxFruits, right - left + 1);
            }

            right++;
        }

        return maxFruits;
    }
}
