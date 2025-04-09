/*
Sort 0s, 1s and 2s
Difficulty: MediumAccuracy: 50.58%Submissions: 760K+Points: 4Average Time: 10m
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2
*/

// soln -->
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int[] count=new int[3];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) count[0]++;
            else if(arr[i]==1) count[1]++;
            else count[2]++;
        }
        int zeros=count[0];
        int ones=count[1];
        int  twos=count[2];
        
        int k=0;
        for(int j=k;j<zeros;j++)
        {
            arr[k]=0;
            k++;
        }
        
        for(int l=0;l<ones;l++) 
        {
            arr[k]=1;
            k++;
        }
        
        for(int m=0;m<twos;m++)
        {
            arr[k]=2;
            k++;
        }
    }
}
