/*
 *  Time Complexity : O(N^2)
 *  Space Complexity : O(1)
 *  Maintin aing a HashMap to store the characters and their frequency.
 *  If we encounter a repeating character, we break the inner loop and move to the next starting point.
 *  We calculate the length of the substring and update the maxLength variable if the current length is greater than the maxLength.
 *  This approach ensures that we check all possible substrings and find the longest one without repeating characters.
 */

public class LongestSubStringWithRepeatingCharactersBrute {
    public int longestNonRepeatingSubstring(String s) {

        int maxLength = 0;

        for(int i = 0 ; i < s.length(); i++){
            int[] hashMap = new int[255];

            for(int j =i; j < s.length(); j++){
                if(hashMap[s.charAt(j)] == 1)
                    break;
                
                int len = j - i + 1;

                maxLength = Math.max(len, maxLength);
                hashMap[s.charAt(j)] = 1;
            }
        }

        return maxLength;
    }
}
