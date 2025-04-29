/*
287. Find the Duplicate Number
Solved
Medium
Topics
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/

//code - 
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
    return 0;
    }
}

//second approach using hashset in o(n)
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            boolean duplicate=set.add(nums[i]);
            if(!duplicate) return nums[i];
        }
    return 0;
    }
}


//this is without using extra space and o(n)
class Solution {
    public int findDuplicate(int[] nums) {
        int current=nums[0];
        int i=0;
        while(nums[i]!=-1){
            current=nums[i];
            int oldi=i;
            i=nums[i];
            nums[oldi]=-1;
        }
    return current;
    }
}
//-> here we track the cycle when we again reach to that element than it is duplicate
//but here we updating array

//final approach
//here we used linked list cycle and floyds algo to detect start of cycle
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);

        slow=nums[0];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
