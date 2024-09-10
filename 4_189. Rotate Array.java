/*
189. Rotate Array
Medium
Topics
Runtime - 2 ms | Beats - 29.04% 
Memory - 57.24 MB | Beats - 64.36%

Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

//Solution using extra space 
class Solution {
    public void rotate(int[] nums, int k) {
        int i=0,location;
        int[] arr=new int[nums.length];

        while(i <= nums.length-1)
        {
            location=(i+k)%nums.length; // to rotate array carcularly
            arr[location]=nums[i];
            i++;
        }
        for (i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}

// Solution Without using extra space

class Solution {
    public void rotate(int[] nums, int k) {
        // Ensure k is within the bounds of the array length otherwise it will if k > length of array
        k = k % nums.length; 
        
        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    // Helper function to reverse a section of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap the elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Move towards the middle
            start++;
            end--;
        }
    }
}

