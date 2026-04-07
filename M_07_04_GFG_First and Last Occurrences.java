/*
First and Last Occurrences
Difficulty: MediumAccuracy: 37.36%Submissions: 316K+Points: 4Average Time: 15m
Given a sorted array arr with possibly some duplicates, the task is to find the first and last occurrences of an element x in the given array.
Note: If the number x is not found in the array then return both the indices as -1.

Examples:

Input: arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
Output: [2, 5]
Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5
Input: arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125], x = 7
Output: [6, 6]
Explanation: First and last occurrence of 7 is at index 6
Input: arr[] = [1, 2, 3], x = 4
Output: [-1, -1]
Explanation: No occurrence of 4 in the array, so, output is [-1, -1]
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], x ≤ 109

*/

//code 
//using 2 for loops
class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                list.add(i);
                break;
            }
        }
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==x){
                list.add(i);
                break;
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
            list.add(-1);
        }
        return list;
    }
}


//using single while loop
class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        
        int start=0;
        int end=arr.length-1;
        boolean f=false;
        boolean l=false;
        while(start<=end){
            if(!f && arr[start]==x){
                if(!list.isEmpty()){
                    int s=list.get(0);
                    list.remove(0);
                    list.add(start);
                    list.add(s);
                }else list.add(start);
                f=true;
            }
            
            if(!l && arr[end]==x){
                list.add(end);
                l=true;
            }
            
            if(!f)start++;
            if(!l)end--;
            if(f && l) break;
        }
        
        if(list.isEmpty()){
            list.add(-1);
            list.add(-1);
        }
        return list;
    }
}
