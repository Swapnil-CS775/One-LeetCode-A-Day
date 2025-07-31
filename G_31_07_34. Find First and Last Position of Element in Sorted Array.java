package com.question;

import java.util.Arrays;

//34. Find First and Last Position of Element in Sorted Array
/*
* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
* */

//this is solved on intellij 
//first approach
public class FL {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;

        int[] ans=findPosition(nums,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] findPosition(int[] nums,int target){
        int s=0;
        int e=nums.length-1;
        int index=-1;

        if(nums.length==1 && nums[0]==target){
            return new int[] {0,0};
        }

        while(s<=e){
            int mid=s+(e-s)/2;

            if(nums[mid]==target){
                index=mid;
                break;
            } else if (nums[mid]<target) {
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        if(s>e){
            return new int[] {-1,-1};
        }

        int start=index,end=index;
        while(end<nums.length && nums[index]==nums[end]){
            end++;
        }

        while(start>=0 && nums[index]==nums[start]){
            start--;
        }

        return new int[] {start+1,end-1};
    }
}


//second approach
//optimized approach using modified binary search ..
//here we not stop even we get one occurence we just assume is will be one probable ans and store it in i ...we do it for both side left and right 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s=modifiedBinarySearch(nums,target,true);
        int e=modifiedBinarySearch(nums,target,false);
        
        return new int[] {s,e};
    }

    int modifiedBinarySearch(int[] nums, int target,boolean isLeft){
        int start=0;
        int end=nums.length-1;
        int i=-1;

        while (start<=end){
            int mid=start+(end-start)/2;

            if(target>nums[mid]){
                start=mid+1;
            } else if (target<nums[mid]) {
                end=mid-1;
            }else{
                i=mid;
                if(isLeft){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }
        }

        return i;
    }
}
