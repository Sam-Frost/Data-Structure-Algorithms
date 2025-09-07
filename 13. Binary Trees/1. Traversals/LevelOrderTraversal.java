/*
* Time Complexity: O(N)
* Space Complexity: O(N)
* We use a queue to facilitate level order traversal of the binary tree.
* We start by adding the root node to the queue.
* We then enter a loop that continues until the queue is empty.
* In each iteration, we determine the number of nodes at the current level (levelNum).
* We create a sublist to hold the values of the nodes at this level.
* We then process each node at the current level by dequeuing it, adding its value to the sublist,
* and enqueuing its left and right children (if they exist).
* After processing all nodes at the current level, we add the sublist to the result list.
* Finally, we return the result list containing the level order traversal of the binary tree.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    private static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        if (root == null) {
            return ans;
        }

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                subList.add(queue.poll().data);
            }
            ans.add(subList);
        }

        return ans;
    }
}
