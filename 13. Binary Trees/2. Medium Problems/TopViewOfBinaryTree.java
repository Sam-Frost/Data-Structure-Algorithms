/*
 * Time Complexity: O(N log N) N is number of nodes in the tree
 * Space Complexity: O(N)
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    public static class Pair {

        TreeNode node;
        int x;

        Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public List<Integer> topView(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        List<Integer> topView = new ArrayList<>();

        TreeMap<Integer, Pair> treeMap = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int x = pair.x;

            treeMap.putIfAbsent(x, pair);

            if (node.left != null) {
                queue.offer(new Pair(node.left, x - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, x + 1));
            }
        }

        for (Pair pair : treeMap.values()) {
            topView.add(pair.node.data);
        }

        return topView;
    }
}
