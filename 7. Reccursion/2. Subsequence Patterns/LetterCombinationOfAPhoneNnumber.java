/*
 * Time Complexity: O(4^n * n) where n is the length of the input digits string
 * Space Complexity: O(n) for recursive stack space
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfAPhoneNnumber {

    public List<String> letterCombinations(String digits) {

        HashMap<Integer, Character[]> numToCharMap = new HashMap<>();

        numToCharMap.put(2, new Character[]{'a', 'b', 'c'});
        numToCharMap.put(3, new Character[]{'d', 'e', 'f'});
        numToCharMap.put(4, new Character[]{'g', 'h', 'i'});
        numToCharMap.put(5, new Character[]{'j', 'k', 'l'});
        numToCharMap.put(6, new Character[]{'m', 'n', 'o'});
        numToCharMap.put(7, new Character[]{'p', 'q', 'r', 's'});
        numToCharMap.put(8, new Character[]{'t', 'u', 'v'});
        numToCharMap.put(9, new Character[]{'w', 'x', 'y', 'z'});

        ArrayList<String> ans = new ArrayList<>();

        solve(digits, numToCharMap, new StringBuilder(), ans, 0);

        return ans;
    }

    private void solve(String digits, HashMap<Integer, Character[]> numToCharMap, StringBuilder curr, List<String> ans, int index) {

        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        Character[] characters = numToCharMap.get(Integer.parseInt(String.valueOf(digits.charAt(index))));

        int i = 0;
        while (i < characters.length) {
            curr.append(characters[i]);
            solve(digits, numToCharMap, curr, ans, index + 1);
            curr.deleteCharAt(curr.length() - 1);
            i++;
        }
    }
}
