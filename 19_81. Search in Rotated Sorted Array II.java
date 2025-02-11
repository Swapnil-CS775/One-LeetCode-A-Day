/*
81. Search in Rotated Sorted Array II
Solved
Medium
Runtime - 0 ms | Beats - 100.00%
Memory - 43.02 MB | Beats - 71.39%

There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 


*/
class Solution {
    public boolean search(int[] nums, int target) {
        // Handle edge case for empty array or array with one element
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }

        int start = 0, end = nums.length - 1;
        int pivot = findPivot(nums, start, end);

        if (pivot == -1) {
            // Array is not rotated, perform binary search on the entire array
            return binarySearch(nums, target, start, end);
        }

        // Determine which part of the array to search
        if (nums[pivot] == target) {
            return true;
        } else if (nums[start] <= target && target < nums[pivot]) {
            return binarySearch(nums, target, start, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, end);
        }
    }

    private boolean binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private int findPivot(int[] nums, int start, int end) {
        while (start <= end) {
            if (start == end) {
                return start;
            }

            int mid = start + (end - start) / 2;

            // Handle edge cases
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) { // this case for handeling non distinct element
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

/*
Explaination - this is also simple problem in which array is rotated but just it contain non distinct element sorted
*/
