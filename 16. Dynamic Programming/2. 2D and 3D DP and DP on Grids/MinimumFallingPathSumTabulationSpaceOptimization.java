/*
 * Time Complexity : O(n*n)
 * Space Complexity : O(n)
 */

public class MinimumFallingPathSumTabulationSpaceOptimization {

    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;

        int[] prev = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            int[] temp = new int[matrix[i].length];

            for (int j = 0; j < matrix[i].length; j++) {

                if (i == 0) {
                    temp[j] = matrix[i][j];
                    continue;
                }

                int topl = 2_000_000;
                int topr = 2_000_000;

                int top = matrix[i][j] + prev[j];
                if (j - 1 >= 0) {
                    topl = matrix[i][j] + prev[j - 1];
                }
                if (j + 1 < matrix[i].length) {
                    topr = matrix[i][j] + prev[j + 1];
                }

                temp[j] = Math.min(top, Math.min(topl, topr));
            }

            prev = temp;

            if (i == matrix.length - 1) {
                for (int k = 0; k < prev.length; k++) {
                    min = Math.min(min, prev[k]);
                }
            }
        }
        return min;
    }
}
