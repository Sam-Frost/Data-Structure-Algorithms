/*
 * Time Complexity: O(N^2) where N is number of elements in stack
 * Space Complexity: O(N) for recursive stack space
 */
import java.util.Stack;

public class ReverseStack {

    public void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }

    private void insertAtBottom(Stack<Integer> st, int element) {
        if (st.isEmpty()) {
            st.push(element);
        } else {
            int top = st.pop();
            insertAtBottom(st, element);
            st.push(top);
        }
    }
}
