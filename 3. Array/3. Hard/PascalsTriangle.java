/*
 * Time Complexity: O(numRows^2)
 * Space Complexity: O(numRows^2)
 * This code generates Pascal's Triangle up to a given number of rows.
 * Each element in the triangle is the sum of the two elements directly above it.
 * The first and last elements of each row are always 1.
 * The triangle is represented as a list of lists, where each inner list corresponds to a row in the triangle.
 * For example, for numRows = 5, the output will be:
 * [
 *  [1],
 * [1, 1],
 * [1, 2, 1],
 * [1, 3, 3, 1],
 * [1, 4, 6, 4, 1]
 * ]
 */
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 1; j <= i; j++) {

                if (j == 1 || j == i) {
                    row.add(1);
                } else {

                    List<Integer> prevRow = ans.get(ans.size() - 1);
                    row.add(prevRow.get(j - 1) + prevRow.get(j - 2));
                }

            }

            ans.add(row);
        }

        return ans;
    }
}
