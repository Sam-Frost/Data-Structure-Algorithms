/*
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
import java.util.ArrayList;
import java.util.List;

public class DFS {

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V + 1];
        visited[0] = true;

        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        dfs(V, adj, 0, visited, ans);

        return ans;
    }

    private void dfs(int V, List<List<Integer>> adj, int curr, boolean[] visited, List<Integer> ans) {
        for (Integer currAdj : adj.get(curr)) {
            if (!visited[currAdj]) {
                visited[currAdj] = true;
                ans.add(currAdj);
                dfs(V, adj, currAdj, visited, ans);
            }
        }
    }
}
