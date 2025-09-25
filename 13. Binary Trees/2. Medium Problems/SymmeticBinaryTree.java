/*
 * Time Complexity: O(N) N is number of nodes in the tree
 * Space Complexity: O(h) h is height of tree
 */
public class SymmeticBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetricHelp(root.left, root.right);
        //your code goes here
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.data != right.data) {
            return false;
        }

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
