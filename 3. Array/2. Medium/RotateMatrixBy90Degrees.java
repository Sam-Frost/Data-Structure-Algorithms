/*
* Time Complexity: O(N^2), where N is the number of rows or columns in the matrix.
* Space Complexity: O(1) as we are rotating the matrix in place.
 */
public class RotateMatrixBy90Degrees {

    public void rotateMatrix(int[][] matrix) {
        // Diagonal Exchange
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j);
            }
        }

        // Flip Cols
        for (int i = 0; i < matrix[0].length / 2; i++) {
            flipCol(matrix, i, matrix[0].length - 1 - i);
        }
    }

    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void flipCol(int[][] matrix, int i, int j) {

        for (int k = 0; k < matrix.length; k++) {
            int temp = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = temp;
        }
    }
}
