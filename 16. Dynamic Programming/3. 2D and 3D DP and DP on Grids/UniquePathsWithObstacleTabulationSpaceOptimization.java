/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(n)
 */

public class UniquePathsWithObstacleTabulationSpaceOptimization {

    public int uniquePathsWithObstacles(int[][] matrix) {

        int[] temp = new int[matrix[0].length];
        int prevCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i == 0 && j == 0 && matrix[i][j] == 0) {
                    temp[j] = 1;
                    prevCol = 1;
                    continue;
                }

                int right = 0;
                int down = 0;

                if (matrix[i][j] == 0) {
                    // Move right
                    if (j > 0) {
                        right = prevCol;
                    }

                    // Move down
                    if (i > 0) {
                        down = temp[j];
                    }
                }

                prevCol = right + down;
                temp[j] = prevCol;
            }
        }

        return prevCol;
    }
}
