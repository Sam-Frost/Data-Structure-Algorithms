/*
 * Time Compleixty: O(V + E)
 * Space Complexity: O(V)
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInUndirectedGraphBFS {

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean isCycle = dfs(i, adj, visited);

                if (isCycle) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int V, List<Integer>[] adj, boolean[] visited) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(V, -1));

        visited[V] = true;

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();

            List<Integer> currAdj = adj[currPair.node];
            int parent = currPair.parent;

            for (Integer currInt : currAdj) {
                if (!visited[currInt]) {
                    visited[currInt] = true;
                    queue.offer(new Pair(currInt, currPair.node));
                } else if (parent != currInt) {
                    return true;
                }
            }
        }

        return false;
    }

    class Pair {

        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
