/*
 *  Time Complexity : O(N)
 *  Space Complexity : O(1)
 *  We use a sliding window approach with two pointers (low and high) to maintain a window of non-repeating characters.
 *  We also use a hashMap to store the last index of each character.
 *  As we expand the window by moving the high pointer, we check if the character at the high pointer has been seen before and is within the current window.
 *  If it has, we move the low pointer to the right of the last seen index of that character to ensure all characters in the window are unique.
 *  We calculate the length of the current window and update the maxLength variable if the current length is greater than the maxLength.
 *  This approach ensures that we traverse the string only once, resulting in a linear time complexity.
 *  The space complexity is constant since the hashMap size is fixed (256 for ASCII characters).
 */

import java.util.Arrays;

public class LongestSubStringWithRepeatingCharactersOptimal {
    public int longestNonRepeatingSubstring(String s) {

    int maxLength = 0;
    int low = 0;
    int high = 0;
    int[] hashMap = new int[256];
    Arrays.fill(hashMap, -1);

    while (high < s.length()) {
      if (hashMap[s.charAt(high)] >= low) {
        low = hashMap[s.charAt(high)] + 1;
      }
      int length = high - low + 1;
      maxLength = Math.max(maxLength, length);
      hashMap[s.charAt(high)] = high;
      high++;
    }

    return maxLength;
  }
}
