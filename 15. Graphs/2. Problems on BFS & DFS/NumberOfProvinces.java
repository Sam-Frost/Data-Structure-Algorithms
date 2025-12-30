/*
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public int numProvinces(int[][] adj) {

        // Convert adj matrix to adj list
        List<List<Integer>> adjList;
        adjList = new ArrayList<>();

        for (int i = 0; i < adj.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = i + 1; j < adj[i].length; j++) {
                if (adj[i][j] == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[adj.length];
        int numberOfProvinces = 0;

        // DFS for all Vertices
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                numberOfProvinces++;
                dfs(adj.length, adjList, visited, i);
            }
        }

        return numberOfProvinces;
    }

    private void dfs(int v, List<List<Integer>> adjList, boolean[] visited, int startVertice) {
        for (Integer vertice : adjList.get(startVertice)) {
            if (!visited[vertice]) {
                visited[vertice] = true;
                dfs(v, adjList, visited, vertice);
            }
        }
    }
}
