
class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int currMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currMax += 1;
                max = Math.max(max, currMax);
            } else {
                currMax = 0;
            }
        }

        return max;
    }
}
