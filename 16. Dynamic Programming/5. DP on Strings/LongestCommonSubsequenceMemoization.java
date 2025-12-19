/*
 * Time Complexity: O(N*M) where N and M are the lengths of the two strings.
 * Space Complexity: O(N*M) for dp array.
 */

import java.util.Arrays;

public class LongestCommonSubsequenceMemoization {

    public int lcs(String str1, String str2) {

        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 0; i < dp.length; i++) {
            int[] temp = new int[str2.length()];
            Arrays.fill(temp, -1);
            dp[i] = temp;
        }

        return helper(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }

    private int helper(String s1, String s2, int index1, int index2, int[][] dp) {

        // Base Case : Traversed all of string
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // Matching character both move to the next index
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + helper(s1, s2, index1 - 1, index2 - 1, dp);
        }

        int one = helper(s1, s2, index1 - 1, index2, dp);
        int two = helper(s1, s2, index1, index2 - 1, dp);

        return dp[index1][index2] = Math.max(one, two);
    }
}
