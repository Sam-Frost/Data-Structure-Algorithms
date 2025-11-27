/*
 * Time Complexity: O(9^(n*n)) where n is the size of the board
 * Space Complexity: O(n*n) for recursive stack space
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudukoSolver {

    public void solveSudoku(char[][] board) {

        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<List<Set<Integer>>> subGrid = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Populate present rows
        for (i = 0; i < 9; i++) {
            Set<Integer> currRow = new HashSet<>();
            for (j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    currRow.add(Integer.parseInt(String.valueOf(board[i][j])));
                }
            }
            rows.add(currRow);
        }

        // Populate present cols
        for (i = 0; i < 9; i++) {
            Set<Integer> currCol = new HashSet<>();
            for (j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    currCol.add(Integer.parseInt(String.valueOf(board[j][i])));
                }
            }
            cols.add(currCol);
        }

        // Populate present sub grids
        for (int k = 0; k < 9; k += 3) {
            List<Set<Integer>> currList = new ArrayList<>();
            for (int l = 0; l < 9; l += 3) {
                Set<Integer> currSubGrid = new HashSet<>();
                for (i = k; i < k + 3; i++) {
                    for (j = l; j < l + 3; j++) {
                        if (board[i][j] != '.') {
                            currSubGrid.add(Integer.parseInt(String.valueOf(board[i][j])));
                        }
                    }
                }
                currList.add(currSubGrid);
            }
            subGrid.add(currList);
        }

        // Run the reccusrion from the empty cell
        helper(board, rows, cols, subGrid);
    }

    public boolean helper(
            char[][] board,
            List<Set<Integer>> rows,
            List<Set<Integer>> cols,
            List<List<Set<Integer>>> subGrid) {

        // Check Every Element
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    // Place Element
                    for (int k = 1; k <= 9; k++) {
                        if (isEligible(i, j, rows, cols, subGrid, k)) {

                            // Place the element
                            board[i][j] = (char) ('0' + k);

                            // Update the row, column, subGridList
                            addValueToCount(i, j, rows, cols, subGrid, k);

                            boolean isSolved = helper(board, rows, cols, subGrid);

                            if (isSolved) {
                                return true;
                            }

                            board[i][j] = '.';

                            // Update the row, column, subGridList
                            removeValueFromCount(i, j, rows, cols, subGrid, k);
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEligible(
            int i,
            int j,
            List<Set<Integer>> rows,
            List<Set<Integer>> cols,
            List<List<Set<Integer>>> subGrid,
            int val) {

        boolean presentInRow = rows.get(i).contains(val);
        boolean presentInCol = cols.get(j).contains(val);
        boolean presentInSubGrid = subGrid.get(i / 3).get(j / 3).contains(val);

        return !(presentInRow || presentInCol || presentInSubGrid);
    }

    private void addValueToCount(
            int i,
            int j,
            List<Set<Integer>> rows,
            List<Set<Integer>> cols,
            List<List<Set<Integer>>> subGrid,
            int val) {
        rows.get(i).add(val);
        cols.get(j).add(val);

        subGrid.get(i / 3).get(j / 3).add(val);
    }

    private void removeValueFromCount(
            int i,
            int j,
            List<Set<Integer>> rows,
            List<Set<Integer>> cols,
            List<List<Set<Integer>>> subGrid,
            int val) {
        rows.get(i).remove(val);
        cols.get(j).remove(val);

        subGrid.get(i / 3).get(j / 3).remove(val);
    }
}
