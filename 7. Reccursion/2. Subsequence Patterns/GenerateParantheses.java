/*
 * Time Complexity: O(2^n) where n is the number of pairs of parentheses
 * Space Complexity: O(n) for recursive stack space
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        // generate(n, "", list);
        generate(0, "", 0, 0, list, n);
        return list;
    }

    private void generate(int index, String current, int open, int close, List<String> list, int n) {
        if (open > n) {
            return;
        }

        if (open == close && open + close == 2 * n) {
            list.add(current);
            return;
        }

        generate(index + 1, current + "(", open + 1, close, list, n);
        if (open > close) {
            generate(index + 1, current + ")", open, close + 1, list, n);
        }

    }

//   private void generate(int n, String current, List<String> list) {
//     if (isValid(current, n)) {
//       list.add(current);
//     }
//     if (current.length() > n * 2) {
//       return;
//     }
//     generate(n, current + "(", list);
//     generate(n, current + ")", list);
//   }
//   private boolean isValid(String s, int n) {
//     if (s.length() != 2 * n || s.length() == 0) {
//       return false;
//     }
//     Stack<Character> st = new Stack<>();
//     for (int i = 0; i < s.length(); i++) {
//       if (st.isEmpty()) {
//         st.push(s.charAt(i));
//       } else if (s.charAt(i) == ')' && st.peek() == '(') {
//         st.pop();
//       } else {
//         st.push(s.charAt(i));
//       }
//     }
//     return st.isEmpty();
//   }
}
