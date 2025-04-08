/*
215. Kth Largest Element in an Array
Attempted
Medium
Topics
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/

// first approch using bubble sort = it give Time Limit Exceeded error 
//o(n^2)
//soln--> 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    return nums[nums.length - k];
    }
}

//second soln using merge sort
// solved
/*
Time Complexity Analysis:
Dividing: The dividing process takes O(log n) time, as the list is repeatedly halved. 
Merging: The merging process takes O(n) time, as it involves comparing and combining elements from two sublists. 
Overall Complexity: Combining the dividing and merging steps, the overall time complexity becomes O(n log n). 
*/
//soln->
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] a=mergeSort(nums);
        return a[nums.length-k];
    }

    public int[] mergeSort(int[] nums){
        if(nums.length==1) return nums;
        int mid=nums.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }

    public int[] merge(int[] arr1,int[] arr2){
        int[] newArr=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                newArr[k]=arr1[i];
                i++;
                k++;
            }
            else{
                newArr[k]=arr2[j];
                j++;
                k++;
            }
        }

        while(i<arr1.length){
            newArr[k]=arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            newArr[k]=arr2[j];
            j++;
            k++;
        }
    return newArr;
    }
}

//third approch 
//create min heap and remove element at top k time
//time = n + k log n

//this we will solve later bcz i need to properly learn ArrayList first .........
