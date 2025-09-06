import java.util.ArrayList;
import java.util.List;
/* 
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is the height of the tree
 * We use a recursive approach to traverse the binary tree in preorder fashion.
 * We start from the root node and add its value to the result list.
 * Then we recursively traverse the left subtree followed by the right subtree.
 * We handle the base case where the current node is null by returning immediately.
 * The result list is built up as we traverse the tree and is returned at the end.
 */

public class PreorderTraversalRecursive {

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

    public List<Integer> preorder(TreeNode root) {
        // your code goes here
        List<Integer> preorder = new ArrayList<>();

        traversePreorder(root, preorder);

        return preorder;

    }

    private void traversePreorder(TreeNode root, List<Integer> preorder) {
        if (root == null)
            return;

        preorder.add(root.data);

        traversePreorder(root.left, preorder);
        traversePreorder(root.right, preorder);
        return;
    }

}