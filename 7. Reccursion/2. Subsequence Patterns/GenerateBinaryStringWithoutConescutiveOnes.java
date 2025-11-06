
/*
 * Time Complexity: O(2^N) where N is the length of binary string
 * Space Complexity: O(N) for recursive stack space
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithoutConescutiveOnes {

    public List<String> generateBinaryStrings(int n) {
        List<String> strings = new ArrayList<>();

        generate(n, "", strings);

        return strings;
    }

    private void generate(int n, String s, List<String> strings) {
        if (n == 0) {
            strings.add(s);
            return;
        }
        generate(n - 1, s + "0", strings);
        if (!s.isEmpty()) {
            if (s.charAt(s.length() - 1) != '1') {
                generate(n - 1, s + "1", strings);
            }
        } else {
            generate(n - 1, s + "1", strings);

        }
    }
}
