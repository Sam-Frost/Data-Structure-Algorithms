/*
 * Time Complexity : O(N)
 * Space Complexity: O(h) h is height of tree
 * 
 */

public class DiameterOfBinaryTree {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return this.diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        this.diameter = Math.max(this.diameter, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
