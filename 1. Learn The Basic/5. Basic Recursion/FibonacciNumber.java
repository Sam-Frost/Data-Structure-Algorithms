/*
 * Time Complexity: O(2^N)
 * Space Complexity: O(N) (recursion stack)
 * This is a basic recursive solution to find the Nth Fibonacci number.
 * The function checks for the base cases where n is 0 or 1, returning n in those cases.
 * For other values of n, it recursively calls itself to compute the sum of the two preceding Fibonacci numbers, fib(n-1) and fib(n-2).
 * This approach has exponential time complexity due to the overlapping subproblems, making it inefficient for large values of n
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 2) + fib(n - 1);
    }
}
