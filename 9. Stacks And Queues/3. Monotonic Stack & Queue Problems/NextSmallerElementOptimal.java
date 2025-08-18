/*
 *  Time Complexity: O(2N)
 *  Space Complexity: O(n) + O(n) = O(n)
 *  This optimal solution uses a stack to keep track of the next smaller elements.
 *  It iterates through the array in reverse order, maintaining a stack of elements for which the next smaller element has not yet been found.
 *  For each element, it pops elements from the stack that are greater than or equal to the current element, ensuring that the stack only contains potential next smaller elements.
 *  If the stack is empty after popping, it means there is no next smaller element for the current element, and -1 is stored in the result array.
 *  The modulo operation is not needed here since we are not dealing with a circular array.
 */

import java.util.Stack;

public class NextSmallerElementOptional {
    public int[] nextSmallerElements(int[] arr) {

    Stack<Integer> st = new Stack<>();
    int[] ans = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {

      while (!st.isEmpty() && st.peek() >= arr[i]) {
        st.pop();
      }

      // No NSE
      if (st.isEmpty()) {
        ans[i] = -1;
      }
      // NSE Present
      else {
        ans[i] = st.peek();
      }
        st.push(arr[i]);
    }

    return ans;
  }
}
