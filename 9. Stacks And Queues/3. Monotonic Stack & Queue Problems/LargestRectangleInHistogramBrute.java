import java.util.Stack;

public class LargestRectangleInHistogramBrute {
     /*

  Brute Force -  I 

  public int largestRectangleArea(int[] heights) {

    int maxArea = 0;

    for (int i = 0; i < heights.length; i++) {

      int currArea = 0;
      int j = i;

      // Traverse Left
      while (0 <= j && heights[j] >= heights[i]) {
        currArea += heights[i];
        j--;
      }

      // Traverse Right
      j = i;
      while (j < heights.length && heights[j] >= heights[i]) {
        currArea += heights[i];
        j++;
      }

      // Height is double calculated
      currArea -= heights[i];

      if (currArea > maxArea) maxArea = currArea;
    }

    return maxArea;
  }

  */

  // Brute Force - II
  public int largestRectangleArea(int[] heights) {

    // These contain indexes not the actual values
    int[] nse = nextSmallerElement(heights);
   int[] pse = previousSmallerElement(heights);

    int maxArea = 0;

    for(int i = 0; i < heights.length; i++){
        
       int currArea = heights[i] * (nse[i] - pse[i] - 1);
       maxArea = Math.max(currArea, maxArea);
    }
    
    return maxArea;

  }

  public int[] nextSmallerElement(int[] heights) {

    Stack<Integer> st = new Stack<>();
    int[] nse = new int[heights.length];

    for( int i = heights.length - 1; i >= 0; i--){
        
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
        }
        
        if(st.isEmpty()){
            nse[i] = heights.length;
        } else {
            nse[i] = st.peek();
        }

        st.push(i);
    }

    return nse;
  }

  public int[] previousSmallerElement(int[] heights) {

    Stack<Integer> st = new Stack<>();
    int[] pse = new int[heights.length];

    for (int i = 0; i < heights.length; i++) {
      while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        st.pop();
      }

        if(st.isEmpty()){
            pse[i] = -1;
        } else {
            pse[i] = st.peek();
        }

      st.push(i);
    }

    return pse;
  }
}
