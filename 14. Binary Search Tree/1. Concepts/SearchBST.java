/* Time Complexity : O(H) H is height of the tree O(log2 N)
 */

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data == val) {
            return root;
        } else if (root.data > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
