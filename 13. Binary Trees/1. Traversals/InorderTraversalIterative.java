
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
 * Time Complexity : O(n)
 * Space Complexity : O(h) h is the height of the tree 
 */
public class InorderTraversalIterative {

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
        Stack<TreeNode> st = new Stack();

        TreeNode node = root;

        while (true) {

            if (node != null) {
                st.push(node);
                node = node.left;
            } else {

                if (st.isEmpty()) {
                    break;
                }

                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }

}
