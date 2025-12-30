/*
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SecondLargestElementInArrayWithoutSorting {

    public int secondLargestElement(int[] nums) {

        if (nums.length < 2) {
            return -1;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num < first && num > second) {
                second = num;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
}
