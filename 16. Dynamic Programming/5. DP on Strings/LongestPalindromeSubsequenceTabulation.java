/*
 * Time Complexity: O(N^2) where N is the length of the string.
 * Space Complexity: O(N^2) for dp array.
 */

public class LongestPalindromeSubsequenceTabulation {

    public int longestPalinSubseq(String s) {

        String reverseS = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        // Initial base case, set 0
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= s.length(); i++) {
            dp[0][1] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {

                if (s.charAt(i - 1) == reverseS.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length()][s.length()];

    }
}
