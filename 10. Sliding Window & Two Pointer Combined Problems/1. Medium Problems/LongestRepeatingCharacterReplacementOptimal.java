/*
 *  Time Complexity: O(N)
 *  Space Complexity: O(1)
 *  We use a sliding window approach with two pointers (left and right) to maintain a window of characters.
 *  We also use a frequency array to store the count of each character in the current window.
 *  As we expand the window by moving the right pointer, we increment the count of the character at the right pointer in the frequency array and update the maximum frequency of any character in the current window.
 *  We check if the number of characters that need to be replaced to make all characters in the window the same (calculated as the length of the window minus the maximum frequency) exceeds k.
 *  If it does, we move the left pointer to the right, decrementing the count of the character at the left pointer in the frequency array.
 *  We calculate the length of the current window and update the maxLength variable if the current length is greater than the maxLength.
 *  This approach ensures that we traverse the string only once, resulting in a linear time complexity.
 *  The space complexity is constant since the frequency array size is fixed (26 for uppercase English letters).
 */

public class LongestRepeatingCharacterReplacementOptimal {
      public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int l = 0;
        int r = 0;
        int[] hash = new int[26];
        int maxFreq = 0;

        while(r < s.length()) {
            
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            if((r-l+1)-maxFreq > k) {
                hash[s.charAt(l) - 'A']--;     
                l++;
            }

            maxLength = Math.max(maxLength, (r-l+1));

            r++;
        }
       
        return maxLength;
    }
}
