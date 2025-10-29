/*
 * Time Complexity: O(N log S) where N is number of books and S is the sum of all pages
 * Space Complexity: O(1)   
 */
public class BookAllocationProblem {

    public int findPages(int[] nums, int m) {

        if (m > nums.length) {
            return -1;
        }
        int low = maxValue(nums);
        int high = totalSum(nums);

        while (low <= high) {

            int numberOfPages = (high + low) / 2;

            if (numberOfStudents(nums, numberOfPages) > m) {
                low = numberOfPages + 1;
            } else {
                high = numberOfPages - 1;
            }
        }

        return low;
    }

    private int numberOfStudents(int[] nums, int numberOfPages) {

        int studentCount = 1;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currSum + nums[i] <= numberOfPages) {
                currSum += nums[i];
            } else {
                studentCount++;
                currSum = nums[i];
            }
        }

        return studentCount;
    }

    private int maxValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    private int totalSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
