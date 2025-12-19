/*
 * Time Complexity: O(N*N) where N is the length of the string.
 * Space Complexity: O(N) for dp array.
 */
public class LongestPalindromeSubsequenceTabulationSpaceOptimization {

    public int longestPalinSubseq(String s) {

        String reverseS = new StringBuilder(s).reverse().toString();

        int[] prev = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            int[] curr = new int[s.length() + 1];

            for (int j = 1; j <= s.length(); j++) {

                if (s.charAt(i - 1) == reverseS.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            prev = curr;
        }

        return prev[s.length()];
    }
}
