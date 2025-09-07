
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * We use a stack to facilitate the iterative preorder traversal of the binary tree.
 * We start by pushing the root node onto the stack.
 * We then enter a loop that continues until the stack is empty.
 * In each iteration, we pop the top node from the stack and add its value to the
 * preorder list.
 * We then push the right child of the popped node onto the stack (if it exists),
 * followed by the left child (if it exists). This ensures that the left child is
 * processed before the right child in the next iterations.
 * Finally, we return the preorder list containing the values of the nodes in
 * preorder traversal order. 
 */
public class PreorderTraversalIterative {

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

    public List<Integer> preorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();

            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }

            preorder.add(node.data);
        }

        return preorder;
    }

}
