/*
 *  Time Complexity: O(N^2)
 *  Space Complexity: O(1)
 *  We use a brute-force approach with two nested loops to explore all possible substrings of the input string.
 *  The outer loop iterates through each character of the string as a potential starting point for a substring.
 *  The inner loop extends the substring from the starting point and maintains a frequency array to track the count of each character in the current substring.
 *  We also keep track of the maximum frequency of any character in the current substring.
 *  We calculate the number of changes needed to make all characters in the substring the same by subtracting the maximum frequency from the length of the substring.
 *  If the number of changes is less than or equal to k, we update the answer with the length of the current substring.
 *  If the number of changes exceeds k, we break out of the inner loop as further extension will only increase the number of changes needed.
 *  We return the maximum length of the substring found that can be transformed with at most k changes.
 */

public class LongestRepeatingCharacterReplacementBrute {
      public int characterReplacement(String s, int k) {
        int ans = 0;
        int maxFreq = 0;

        for(int i = 0; i < s.length(); i++){
            
            int[] hash = new int[26];
           

            for(int j = i; j < s.length(); j++) {

                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

                int changes = (j-i+1) - maxFreq;

                if(changes <= k){
                    ans = Math.max(ans, j-i+1);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
