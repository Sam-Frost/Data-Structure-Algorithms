/*
 * Time Complexity: O(N*M) where N is number of rows and M is number of columns in the image
 * Space Complexity: O(N*M) for the queue in the worst case
 */
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) {
            return image;
        }

        Queue<Pair> queue = new LinkedList<>();

        int startColor = image[sr][sc];
        image[sr][sc] = newColor;
        queue.offer(new Pair(sr, sc));

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            int i = curr.i;
            int j = curr.j;

            // Color the neigbours
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (isValid(ni, nj, image, startColor)) {
                    image[ni][nj] = newColor;
                    queue.offer(new Pair(ni, nj));
                }
            }
        }

        return image;
    }

    private boolean isValid(int i, int j, int[][] grid, int startColor) {
        // Index out of bounds
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }
        // Not the start color

        return grid[i][j] == startColor;
    }

    private class Pair {

        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
