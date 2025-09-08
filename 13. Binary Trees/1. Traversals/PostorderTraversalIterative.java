
import java.util.ArrayList;
import java.util.List;

/* 
 * Time Complexity: O(n)
 * Space Complexity: O(h) h is the height of the tree
 * We use an iterative approach to traverse the binary tree in postorder fashion.
 * We use a stack to keep track of the nodes to be processed.
 * We start from the root node and push it onto the stack.
 * We then enter a loop where we pop a node from the stack, add its value to the result list,
 * and push its left and right children onto the stack (if they exist).
 * This ensures that the right child is processed before the left child.
 * After processing all nodes, we reverse the result list to get the correct postorder sequence.
 * The result list is returned at the end. 
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

    public List<Integer> postorder(TreeNode root) {

        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();

            postorder.add(node.data);
            if (node.left != null) {
                st.push(node.left);
            }

            if (node.right != null) {
                st.push(node.right);
            }
        }

        Collections.reverse(postorder);

        return postorder;
    }
}
