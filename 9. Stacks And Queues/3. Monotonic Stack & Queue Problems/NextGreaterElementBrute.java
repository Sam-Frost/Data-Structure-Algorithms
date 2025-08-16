/*
 *  Time Complexity: O(n^2)
 *  Space Complexity: O(n)
 *  This brute force solution iterates through each element in the array and for each element, it checks all subsequent elements to find the next greater element.
 *  If a greater element is found, it is stored in the result array; otherwise, -1 is stored.
 */
public class NextGreaterElementBrute {
     public int[] nextLargerElement(int[] arr) {
    
        int ans[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            ans[i] = -1;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        return ans;
    }
}