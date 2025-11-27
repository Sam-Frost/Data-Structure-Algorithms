
import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(4^(n*n)) where n is the size of the grid
 * Space Complexity: O(n*n) for recursive stack space
 */
public class RatInAMaze {

    public List<String> findPath(int[][] grid) {

        int n = grid.length - 1;

        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        if (grid[0][0] == 0) {
            return ans;
        }

        helper(grid, 0, 0, n, ans, sb);

        return ans;
    }

    public void helper(int[][] grid, int i, int j, int n, List<String> ans, StringBuilder curr) {

        // Reached the desired coordinate
        if (i == n && j == n) {
            ans.add(curr.toString());
            return;
        }

        // Reached the end of matrix
        if (i > n && j > n) {
            return;
        }

        boolean isCurrZero = grid[i][j] == 0;

        grid[i][j] = 0;

        // Move up
        if (i > 0 && grid[i - 1][j] != 0) {
            curr.append("U");
            helper(grid, i - 1, j, n, ans, curr);
            curr.setLength(curr.length() - 1);
        }

        // Move Right
        if (j < n && grid[i][j + 1] != 0) {
            curr.append("R");
            helper(grid, i, j + 1, n, ans, curr);
            curr.setLength(curr.length() - 1);
        }

        // Mode down
        if (i < n && grid[i + 1][j] != 0) {
            curr.append("D");
            helper(grid, i + 1, j, n, ans, curr);
            curr.setLength(curr.length() - 1);
        }

        // Move left
        if (j > 0 && grid[i][j - 1] != 0) {
            curr.append("L");
            helper(grid, i, j - 1, n, ans, curr);
            curr.setLength(curr.length() - 1);
        }

        grid[i][j] = isCurrZero ? 0 : 1;
    }
}
