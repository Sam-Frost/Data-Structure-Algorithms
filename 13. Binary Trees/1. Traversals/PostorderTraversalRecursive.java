import java.util.ArrayList;
import java.util.List;
/* 
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is the height of the tree
 * We use a recursive approach to traverse the binary tree in postorder fashion.
 * We start from the root node and recursively traverse the left subtree followed by the right subtree.
 * Finally, we add the value of the current node to the result list.
 * We handle the base case where the current node is null by returning immediately.
 * The result list is built up as we traverse the tree and is returned at the end.
 */

public class PostorderTraversalRecursive {

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

    public List<Integer> postorder(TreeNode root) {

        List<Integer> preorder = new ArrayList<>();

        traversePostorder(root, preorder);

        return preorder;

    }

    private void traversePostorder(TreeNode root, List<Integer> preorder) {
        if (root == null)
            return;
        traversePostorder(root.left, preorder);
        traversePostorder(root.right, preorder);
        preorder.add(root.data);
        return;

    }
}