/*
 * Time Complexity: O(N log N) N is number of nodes in the tree
 * Space Complexity: O(N)
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    static class Tuple {

        TreeNode node;
        int x; // Vertical distance
        int y; // Level

        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> verticalTraversal = new ArrayList<>();

        if (root == null) {
            return verticalTraversal;
        }

        // Queue for traversal of the tree
        Queue<Tuple> queue = new LinkedList<>();

        // Outer TreeMap - x axis (Horizontal Distance)
        // Inner TreeMap - y axis (Vertical Distance)
        // PriorityQueue - Multiple values at an index
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        queue.offer(new Tuple(root, 0, 0));

        // BFS
        while (!queue.isEmpty()) {

            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            // Add node to map
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.data);

            // Add left child to queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }
            // Add right chid to queue
            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        // Convert the hash map into list of list for final answer
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            verticalTraversal.add(column);
        }

        return verticalTraversal;
    }
}
