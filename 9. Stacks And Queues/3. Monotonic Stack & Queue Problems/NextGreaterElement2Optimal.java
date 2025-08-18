
/*
 *  Time Complexity: O(2N)
 *  Space Complexity: O(n) + O(n) = O(n)
 *  This optimal solution uses a stack to keep track of the next greater elements.
 *  It iterates through the array in reverse order, maintaining a stack of elements for which the next greater element has not yet been found.
 *  For each element, it pops elements from the stack that are less than or equal to the current element, ensuring that the stack only contains potential next greater elements.
 *  If the stack is empty after popping, it means there is no next greater element for the current element, and -1 is stored in the result array.
 *  The modulo operation is used to handle the circular nature of the array, allowing the algorithm to wrap around and find the next greater element even for elements at the end of the array.
 */

import java.util.Stack;

public class NextGreaterElement2Optimal {
    public int[] nextGreaterElements(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[arr.length];

    for (int i = (arr.length*2) - 1; i >= 0; i--) {

      int index = i % arr.length;  

      while (!st.isEmpty() && st.peek() <= arr[index]) {
        st.pop();
      }

      if (i < arr.length){
        ans[i] = st.isEmpty() ? -1 : st.peek();
      }

      st.push(arr[index]);
    }

    return ans;
  }
}