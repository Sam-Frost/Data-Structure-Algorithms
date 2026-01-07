/*
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
 */
import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralManner {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize boundaries
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // 1. Move Right: Across the top row
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++; // Move the top boundary down

            // 2. Move Down: Down the right column
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // 3. Move Left: Across the bottom row
            // Check if top <= bottom to avoid re-processing the same row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--; // Move the bottom boundary up
            }

            // 4. Move Up: Up the left column
            // Check if left <= right to avoid re-processing the same column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return ans;
    }
}
