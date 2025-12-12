/*
 * Time Complexity : O(n) 
 * Space Complexity : O(1)
 * 
 */
public class ClimbingStairsTabulationSpaceOptimized {

    public int climbStairs(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int one = 1;
        int two = 1;

        for (int i = 2; i <= n; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}
