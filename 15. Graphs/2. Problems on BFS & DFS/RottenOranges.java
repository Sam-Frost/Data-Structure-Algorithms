/*
 * Time Complexity: O(N*M) where N and M are the dimensions of the grid
 * Space Complexity: O(N*M) for the queue in the worst case
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        int totalOranges = 0;
        int rottenOranges = 0;

        Queue<Pair> queue = new LinkedList<>();

        // Count Total and Rotten Oranges, and add to queue the initial rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges++;
                    totalOranges++;
                    queue.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    totalOranges++;
                }
            }
        }

        // To Store the final answer
        int minutes = 0;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            // Update the final answer
            minutes = Math.max(curr.time, minutes);

            int i = curr.i;
            int j = curr.j;

            // Rot the neigbours
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (isValid(ni, nj, grid)) {
                    grid[ni][nj] = 2;
                    queue.offer(new Pair(ni, nj, curr.time + 1));
                    rottenOranges++;
                }
            }
        }

        return totalOranges == rottenOranges ? minutes : -1;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        // Index out of bounds
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }

        // Already rotten, or empty space
        if (grid[i][j] != 1) {
            return false;
        }

        return true;
    }

    private class Pair {

        int i;
        int j;
        int time;

        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
}
