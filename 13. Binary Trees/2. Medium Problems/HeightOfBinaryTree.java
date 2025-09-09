/*
* Time Complexity: O(n)
* Space Complexity: O(h) h is height of tree
 */

public class HeightOfBinaryTree {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }
}
