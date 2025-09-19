/*
 * Time Complexity: O(min(m,n)) m and n are number of nodes in two trees
 * Space Complexity: O(h) h is height of tree
 */

public class CheckIfTwoTreeAreIdentical {

    public static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
