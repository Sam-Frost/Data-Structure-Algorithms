package Array;

class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int currMax = 0;

         for(int i = 0; i < nums.length; i++) {

                if(nums[i] == 1) {
                    currMax++;
                } else {

                    // Found new max value, reset current max value
                    if(currMax > max) {
                        max = currMax;
                    }

                     currMax = 0;
                
                }
         }

         if(currMax != 0) {
            // Found new max value, reset current max value
            if(currMax > max) {
                max = currMax;
            }
         }

         return max;
        
    }
}