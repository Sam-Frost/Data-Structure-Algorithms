/*
 * Time Complexity: O(N) N is number of nodes in the tree
 * Space Complexity: O(N)   
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBinaryTree {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightSideView = new ArrayList<>();

        if (root == null) {
            return rightSideView;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            int currLevelRightMost = 0;

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                currLevelRightMost = node.data;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            rightSideView.add(currLevelRightMost);
        }

        return rightSideView;
    }
}
