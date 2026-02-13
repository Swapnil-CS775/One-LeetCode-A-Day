/*
Histogram Max Rectangular Area
Difficulty: HardAccuracy: 32.12%Submissions: 208K+Points: 8
You are given a histogram represented by an array arr[ ], where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 104

Expected Complexities
Company Tags
MicrosoftGoogleNPCI
*/

//code - 
class Solution {
    public static int getMaxArea(int arr[]) {
        // code here
        int maxArea=Integer.MIN_VALUE;
        ArrayList<Integer>i1=new ArrayList<>();
        ArrayList<Integer>i2=new ArrayList<>();
        findNextSmall(i1,arr);
        findPrevSmall(i2,arr);
        
        for(int i=0;i<arr.length;i++){
            int left=i2.get(i);
            int right=i1.get(i);
            if(right==-1) right=arr.length;
            int width=right-left-1;
            maxArea=Math.max(maxArea,width*arr[i]);
        }
        
        return maxArea;
    }
    
    static void findNextSmall(ArrayList<Integer>ans,int[] arr){
        Stack<Integer>stack=new Stack<>();
        Stack<Integer>temp=new Stack<>();
        
        stack.push(-1);
        for(int i=arr.length-1;i>=0;i--){
            while(stack.peek() != -1 && arr[stack.peek()]>=arr[i]) stack.pop();
            temp.push(stack.peek());
            stack.push(i);
        }  
        while(!temp.isEmpty()) ans.add(temp.pop());
    }
    
    static void findPrevSmall(ArrayList<Integer>ans,int[] arr){
        Stack<Integer>stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<arr.length;i++){
            while(stack.peek() != -1 && arr[stack.peek()]>=arr[i]) stack.pop();
            ans.add(stack.peek());
            stack.push(i);
        }  
    }
}
