/*
84. Largest Rectangle in Histogram
Attempted
Hard
Topics
premium lock icon
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/


//code 
//it uses O(n^2)
//approach is correct and give ans but also give TLE for large input 
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        if(heights.length==1) return heights[0];

        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int leftLen=findLeftLen(heights,i-1,heights[i]);
            int rightLen=findRightLen(heights,i+1,heights[i]);
            int area=heights[i]*(leftLen+rightLen+1);
            if(area>maxArea) maxArea=area;
        }

        return maxArea;
    }

    int findLeftLen(int[] arr,int curr,int val){
        int len=0;
        while(curr>=0){
            if(arr[curr]<val) return len;
            len++;
            curr--;
        }
        return len;
    }

    int findRightLen(int[] arr,int curr,int val){
        int len=0;
        while(curr<arr.length){
            if(arr[curr]<val) return len;
            len++;
            curr++;
        }
        return len;
    }
}

// optimal approach using stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<Integer>stack=new Stack<>();

        stack.push(0);
        for(int i=1;i<heights.length;i++){
            while (!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                maxArea=getMax(heights,stack,maxArea,i);
            }
            stack.push(i);
        }
        int i=heights.length;
        while (!stack.isEmpty()){
            maxArea=getMax(heights,stack,maxArea,i);
        }
        return maxArea;
    }

    private int getMax(int[] heights,Stack<Integer>stack,int maxArea,int i){
        int area;
        int popped=stack.pop();
        if(stack.isEmpty()){
            area=heights[popped]*i;
        }
        else {
            area=heights[popped]*(i-1-stack.peek());
        }
        return Math.max(area,maxArea);
    }
}
