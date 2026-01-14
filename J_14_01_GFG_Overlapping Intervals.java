/*
Overlapping Intervals
Difficulty: MediumAccuracy: 57.41%Submissions: 125K+Points: 4Average Time: 20m
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1, 3] and [2, 4] which on merging will become [1, 4]. Therefore we will return [[1, 4], [6, 8], [9, 10]].
Input: arr[][] = [[6, 8], [1, 9], [2, 4], [4, 7]]
Output: [[1, 9]]
Explanation: In the given intervals all the intervals overlap with the interval [1, 9]. Therefore we will return [1, 9].
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ starti ≤ endi ≤ 106
*/

//code - Approach 1 - using sorting and than merging overlapping intervals int O(n^2)

//this give TLE
class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]>ans=new ArrayList<>();
        if(arr.length==0) return ans;
        sort(arr);
        
        int a=arr[0][0];
        int b=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=b) b=arr[i][1]>b ? arr[i][1] : b;
            else{
                ans.add(new int[]{a,b});
                a=arr[i][0];
                b=arr[i][1];
            }
        }
        ans.add(new int[]{a,b});
        return ans;
    }
    
    public void sort(int[][] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j][0]<arr[i][0]){
                    int t1=arr[i][0];
                    int t2=arr[i][1];
                    arr[i][0]=arr[j][0];
                    arr[i][1]=arr[j][1];
                    arr[j][0]=t1;
                    arr[j][1]=t2;
                }
            }
        }
    }
}

//optimal ans but in nlogn 
//here i used inbuilt sort
//code 

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]>ans=new ArrayList<>();
        if(arr.length==0) return ans;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        
        int a=arr[0][0];
        int b=arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=b) b=arr[i][1]>b ? arr[i][1] : b;
            else{
                ans.add(new int[]{a,b});
                a=arr[i][0];
                b=arr[i][1];
            }
        }
        ans.add(new int[]{a,b});
        return ans;
    }
    
    
}
