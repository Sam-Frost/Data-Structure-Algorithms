/*
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * This optimal solution uses a stack to keep track of the digits in the number.
 * It iterates through each digit in the number, and for each digit, it checks if it can remove a previous digit to form a smaller number.
 * If the current digit is smaller than the top of the stack and we still have digits to remove (k > 0), it pops the top of the stack.
 * After processing all digits, it removes any remaining digits if k is still greater than 0.
 * Finally, it constructs the resulting number from the stack, removes leading zeros, and handles the case where the result is an empty string.
 */

import java.util.Stack;

public class RemoveKDigitsOptimal {
  public String removeKdigits(String nums, int k) {

    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < nums.length(); i++) {

      int number = Character.getNumericValue(nums.charAt(i));

      while (!st.isEmpty() && k > 0 && number < st.peek()) {
        st.pop();
        k--;
      }

      st.push(number);
    }

    // Remove remaning elements if K still remains
    while (k > 0) {
      st.pop();
      k--;
    }

    StringBuilder ans = new StringBuilder();

    // Create String
    while (!st.isEmpty()) {
      ans.append(st.peek());
      st.pop();
    }

    // Reverse String
    ans.reverse();

    // Step 4: Remove leading zeros
    while (ans.length() > 1 && ans.charAt(0) == '0') {
      ans.deleteCharAt(0);
    }

    // Step 5: Handle empty string
    return ans.length() == 0 ? "0" : ans.toString();
  }  
}
