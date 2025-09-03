/* 
 * Time Complexity: O(2N)
 * Space Complexity: O(1)
 * We use a sliding window approach with two pointers (left and right) to maintain a
 * window of elements in the array.
 * We use a HashMap to keep track of the count of each character in the current window.
 * As we expand the window by moving the right pointer, we add the character at the right pointer
 * to the HashMap and increment its count.
 * If the size of the HashMap exceeds k (indicating more than k distinct characters in the window),
 * we move the left pointer to the right, decrementing the count of the character at the left pointer
 * in the HashMap. If the count of that character becomes 0, we remove it from the HashMap.
 * We keep track of the maximum length of valid windows encountered during this process.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharactersBetter {
    public int kDistinctChar(String s, int k) {

        int length = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> hashMap;
        hashMap = new HashMap<>();

        while (r < s.length()) {
            hashMap.put(s.charAt(r), (hashMap.getOrDefault(s.charAt(r), 0) + 1));

            while (hashMap.size() > k) {
                hashMap.put(s.charAt(l), hashMap.get(s.charAt(l)) - 1);

                if (hashMap.get(s.charAt(l)) == 0) {
                    hashMap.remove(s.charAt(l));
                }

                l++;
            }

            length = Math.max(length, r - l + 1);

            r++;
        }

        return length;
    }
}
