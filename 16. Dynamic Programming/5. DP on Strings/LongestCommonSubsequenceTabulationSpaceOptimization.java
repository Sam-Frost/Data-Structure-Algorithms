/*
 * Time Complexity: O(N*M) where N and M are the lengths of the two strings.
 * Space Complexity: O(M) for dp array.
 */
public class LongestCommonSubsequenceTabulationSpaceOptimization {

    public int lcs(String str1, String str2) {

        int[] prev = new int[str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            int[] curr = new int[str2.length() + 1];

            for (int j = 1; j <= str2.length(); j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            prev = curr;
        }

        return prev[str2.length()];
    }
}
