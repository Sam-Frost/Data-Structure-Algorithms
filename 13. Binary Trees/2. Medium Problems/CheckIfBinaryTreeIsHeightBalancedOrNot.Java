/*
 * Time Complexity: O(N)
 * Space Complexity: O(h) h is height of tree
 * 
 */

public class CheckIfBinaryTreeIsHeightBalancedOrNot {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root) {
    return maxDepth(root) == -1 ? false : true;
  }

  public int maxDepth(TreeNode root) {

    if (root == null) return 0;

    int lh = maxDepth(root.left);

    if (lh == -1) return -1;

    int rh = maxDepth(root.right);

    if (rh == -1) return -1;

    if (Math.abs(lh - rh) > 1) return -1;

    return 1 + Math.max(lh, rh);
  }

  
}