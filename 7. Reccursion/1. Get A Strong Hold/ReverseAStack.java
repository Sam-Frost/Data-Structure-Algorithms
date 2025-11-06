/*
 * Time Complexity: O(N^2) where N is number of elements in stack
 * Space Complexity: O(N) for recursive stack space 
 */
import java.util.Stack;

public class ReverseAStack {

    public void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        sortStack(st);
        insertInSortedOrder(st, top);
    }

    private void insertInSortedOrder(Stack<Integer> st, int element) {
        if (st.isEmpty() || st.peek() <= element) {
            st.push(element);
        } else {
            int top = st.pop();
            insertInSortedOrder(st, element);
            st.push(top);
        }
    }
}
