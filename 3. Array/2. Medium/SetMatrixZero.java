/*
 * Time Complexity: O(M*N)
 * Space Complexity: O(1)
 * This code sets the entire row and column to zero if an element in a matrix is zero.
 * It first checks if the first row and first column need to be zeroed,
 * then uses the first row and column as markers to indicate which rows and columns should be zeroed.
 * Finally, it updates the matrix based on these markers and handles the first row and column separately.
 * For example, given the matrix:
 * [
 *  [1, 1, 1],
 *  [1, 0, 1],
 *  [1, 1, 1]
 * ]
 * The output will be:
 * [
 *  [1, 0, 1],
 *  [0, 0, 0],
 *  [1, 0, 1]
 * ]    
 */

public class SetMatrixZero {

    public void setZeroes(int[][] matrix) {

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row needs to be zero
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
            }
        }

        // Check if first col needs to be zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // Check through the matrix for all rows and column's
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Update the matrix with the correct values
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;

                }
            }
        }

        // Update the first row and col
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        // Check if first col needs to be zero
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
