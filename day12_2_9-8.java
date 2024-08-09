/*
 *34. Find First and Last Position of Element in Sorted Array
Medium
Runtime - 0 ms | Beats 100%
Memory - 45.89 MB | Beats 46.11%

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

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

 */


 //Solution
 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // Find the starting index of the target
        ans[0] = search(nums, target, true);
        // Find the ending index of the target
        ans[1] = search(nums, target, false);
        return ans;
    }

    private int search(int[] nums, int target, boolean findStartIndex) {
        int start = 0, end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
