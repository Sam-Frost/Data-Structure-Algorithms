/* 
 * Time Complexity: O(N)
 * Space Complexity: O(h) h is height of tree
 *  
 */

public class MaximumPathSum {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    int maxPathSum = 0;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return maxPathSum;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = dfs(root.left);
        lh = Math.max(lh, 0);
        int rh = dfs(root.right);
        rh = Math.max(rh, 0);

        maxPathSum = Math.max(maxPathSum, root.data + lh + rh);

        return root.data + Math.max(lh, rh);
    }
}
