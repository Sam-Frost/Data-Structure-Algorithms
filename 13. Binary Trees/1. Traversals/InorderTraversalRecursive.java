import java.util.ArrayList;
import java.util.List;
/* 
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is the height of the tree
 * We use a recursive approach to traverse the binary tree in inorder fashion.
 * We start from the root node and recursively traverse the left subtree.
 * Then we add the value of the current node to the result list.
 * Finally, we recursively traverse the right subtree.
 * We handle the base case where the current node is null by returning immediately.
 * The result list is built up as we traverse the tree and is returned at the end.
 */

public class InorderTraversalRecursive {

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

    public List<Integer> inorder(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();

        traverseInorder(root, inorder);
        return inorder;

    }

    private void traverseInorder(TreeNode root, List<Integer> inorder) {

        if (root == null)
            return;

        traverseInorder(root.left, inorder);
        inorder.add(root.data);
        traverseInorder(root.right, inorder);
        return;
    }
}