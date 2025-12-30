/*
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int[] visited = new int[V + 1];
        int counter = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u); // undirected graph
        }

        for (int i = 0; i < V; i++) {

            if (visited[i] == 0) {
                counter++;
                bfsOfGraph(V, adjList, visited, i);
            }
        }

        return counter;
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj, int[] visited, int start) {

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {

            Integer curr = queue.poll();
            ans.add(curr);

            List<Integer> currAdj = adj.get(curr);

            for (int i = 0; i < currAdj.size(); i++) {

                Integer temp = currAdj.get(i);

                if (visited[temp] == 0) {
                    queue.offer(temp);
                    visited[temp] = 1;
                }
            }
        }
        return ans;
    }
}
