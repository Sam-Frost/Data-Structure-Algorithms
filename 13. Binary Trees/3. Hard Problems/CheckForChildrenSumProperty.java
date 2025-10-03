/*
     * Time Complexity: O(N) N is number of nodes in the tree
     * Space Complexity: O(H) H is height of the tree
 */

public class CheckForChildrenSumProperty {

    public boolean checkChildrenSum(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int leftData = root.left == null ? 0 : root.left.data;
        int rightData = root.right == null ? 0 : root.right.data;

        boolean left = checkChildrenSum(root.left);
        boolean right = checkChildrenSum(root.right);

        return (left && right) && (root.data == rightData + leftData);
    }

}
