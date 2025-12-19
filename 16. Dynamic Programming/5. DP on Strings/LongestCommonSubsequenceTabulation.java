/*
 * Time Complexity: O(N*M) where N and M are the lengths of the two strings.
 * Space Complexity: O(N*M) for dp array.
 */
public class LongestCommonSubsequenceTabulation {

    public int lcs(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // Initial base case, set 0
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= str2.length(); i++) {
            dp[0][1] = 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];

    }
}
