/*
 * Time Complexity: O(n^2)
 * Space Complexity:O(n)
 * This brute force solution iterates through each element in the array and for each element, it checks all subsequent elements to find the next greater element.
 * If a greater element is found, it is stored in the result array; otherwise, -1 is stored.
 * This approach handles the circular nature of the array by using modulo operation to wrap around the indices.
 */
public class NextGreaterElement2Brute {
    public int[] nextGreaterElements(int[] arr) {

    int[] ans = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {

      boolean ngePresent = false;

      for (int j = i + 1; j < i + arr.length; j++) {
        if (arr[j % arr.length] > arr[i]) {
          ans[i] = arr[j % arr.length];
          ngePresent = true;
          break;
        }
      }

      if (!ngePresent) {
        ans[i] = -1;
      }
    }

    return ans;
  }
}