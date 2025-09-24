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

public class BottomViewOfBinaryTree {

    public static class Pair {

        TreeNode node;
        int x;

        Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public List<Integer> bottomView(TreeNode root) {

        List<Integer> bottomView = new ArrayList<>();

        if (root == null) {
            return bottomView;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        TreeMap<Integer, Pair> treeMap = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int x = pair.x;

            Pair insertedPair = treeMap.put(x, new Pair(node, x));

            if (node.left != null) {
                queue.offer(new Pair(node.left, x - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, x + 1));
            }
        }

        for (Pair pair : treeMap.values()) {
            bottomView.add(pair.node.data);
        }

        return bottomView;
    }
}
