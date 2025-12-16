/*
 * Time Complexity : O(m*n)
 * Space Complexity : O(n)
 * 
 */

import java.util.Arrays;

public class GridUniquePathsTabulationSpaceOptimization {

    public int uniquePaths(int m, int n) {
        int[] temp = new int[n];
        int prevCol = 0;
        Arrays.fill(temp, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    temp[0] = 1;
                    prevCol = 1;
                    continue;
                }

                int right = 0;
                int down = 0;
                // Move Right
                if (j > 0) {
                    right = prevCol;
                }

                // Move Down
                if (i > 0) {
                    down = temp[j];
                }

                prevCol = right + down;

                temp[j] = prevCol;
            }
        }

        return prevCol;
    }
}
