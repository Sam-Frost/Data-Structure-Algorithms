
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[V + 1];

        queue.offer(0);
        visited[0] = 1;

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
