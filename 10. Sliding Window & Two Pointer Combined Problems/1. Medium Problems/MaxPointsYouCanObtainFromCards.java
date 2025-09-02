/*
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * We use a two-pointer approach to calculate the maximum score by taking k cards from either
 * end of the array.
 * We first calculate the sum of the first k cards from the left end of the array.
 * We then iterate k times, each time removing one card from the left end and adding one
 * card from the right end.
 * We keep track of the maximum sum encountered during this process.
 * This approach ensures that we consider all possible combinations of taking k cards from
 * either end of the array.
 * 
 */

public class MaxPointsYouCanObtainFromCards {
    public int maxScore(int[] cardScore, int k) {

      int lSum = 0;
      int rSum = 0;
      int r = cardScore.length - 1;
      
      // Calculate the left sum
      for(int i = 0; i < k; i++){
        lSum += cardScore[i];
      }
      int sum = lSum;

      for(int i = k-1; i >= 0; i--) {
        lSum -= cardScore[i];
        rSum += cardScore[r];
        r--;
        sum = Math.max(sum, lSum + rSum);
      }

      return sum;
    }
}
