/*
Intersection of Two Sorted Arrays with Duplicate Elements
Difficulty: EasyAccuracy: 32.03%Submissions: 2K+Points: 2Average Time: 10m
Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the intersection of the two arrays in sorted order.

Intersection of two arrays can be defined as the set containing distinct common elements that are present in both of the arrays.
Examples:

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3
Explanation: Distinct elements in both the arrays are: 1 2 3.
Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: 2 3 4
Explanation: Distinct elements in both the arrays are: 2 3 4.
Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
Output: []
Explanation: No common elements.
Constraints:
1  <=  a.size(), b.size()  <=  105
-109  <=  a[i] , b[i]  <=  109
*/

//code - 
class Solution {

    // Function to find the intersection of two arrays
    ArrayList<Integer> intersection(int[] a, int[] b) {
        int i=0,j=0;
        ArrayList<Integer>list=new ArrayList<>();
        int last=Integer.MIN_VALUE;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]) i++;
            else if(a[i]>b[j]) j++;
            else{
                if(a[i]!=last){
                    list.add(a[i]);
                    last=a[i];
                }
                i++;
                j++;
            }
        }
    return list;
    }
}
