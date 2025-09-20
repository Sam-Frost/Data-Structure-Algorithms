/*
 *  Time Complexity: O(N)
 *  Space Complexity: O(w) w is max width of tree
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversalOfBinaryTree {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> traversal = new LinkedList<>();

        if (root == null) {
            return traversal;
        }

        boolean traverseLeftToRight = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> currTraversal = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                currTraversal.add(node.data);
            }

            if (!traverseLeftToRight) {
                Collections.reverse(currTraversal);
            }

            traversal.add(currTraversal);
            traverseLeftToRight = !traverseLeftToRight;
        }

        return traversal;
    }
}
