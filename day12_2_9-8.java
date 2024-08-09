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

//Explaination
/*
Example 1:
    Input: nums = [5, 7, 7, 8, 8, 10], target = 8
    Output: [3, 4]

    Finding the Starting Index:
        Initialization:
            start = 0
            end = 5
            result = -1

        Iteration 1:
            mid = 0 + (5 - 0) / 2 = 2
            nums[mid] = 7
            7 < 8 => move right: start = 3

        Iteration 2:
            mid = 3 + (5 - 3) / 2 = 4
            nums[mid] = 8
            8 == 8 => found, set result = 4
            Move end to find the start index: end = 3

        Iteration 3:
            mid = 3 + (3 - 3) / 2 = 3
            nums[mid] = 8
            8 == 8 => found, set result = 3
            Move end to continue searching: end = 2

        Termination:
            result = 3 (start index found)

    Finding the Ending Index:
        Initialization:
            start = 0
            end = 5
            result = -1

        Iteration 1:
            mid = 0 + (5 - 0) / 2 = 2
            nums[mid] = 7
            7 < 8 => move right: start = 3

        Iteration 2:
            mid = 3 + (5 - 3) / 2 = 4
            nums[mid] = 8
            8 == 8 => found, set result = 4
            Move start to find the end index: start = 5

        Iteration 3:
            mid = 5 + (5 - 5) / 2 = 5
            nums[mid] = 10
            10 > 8 => move left: end = 4

        Termination:
            result = 4 (end index found)

Example 2:
    Input: nums = [5, 7, 7, 8, 8, 10], target = 6
    Output: [-1, -1]

    Finding the Starting Index:
        Initialization:
            start = 0
            end = 5
            result = -1

        Iteration 1:
            mid = 0 + (5 - 0) / 2 = 2
            nums[mid] = 7
            7 > 6 => move left: end = 1

        Iteration 2:
            mid = 0 + (1 - 0) / 2 = 0
            nums[mid] = 5
            5 < 6 => move right: start = 1

        Iteration 3:
            mid = 1 + (1 - 1) / 2 = 1
            nums[mid] = 7
            7 > 6 => move left: end = 0

        Termination:
            result = -1 (target not found)

    Finding the Ending Index:
        Initialization:
            start = 0
            end = 5
            result = -1

        Iteration 1:
            mid = 0 + (5 - 0) / 2 = 2
            nums[mid] = 7
            7 > 6 => move left: end = 1

        Iteration 2:
            mid = 0 + (1 - 0) / 2 = 0
            nums[mid] = 5
            5 < 6 => move right: start = 1

        Iteration 3:
            mid = 1 + (1 - 1) / 2 = 1
            nums[mid] = 7
            7 > 6 => move left: end = 0

        Termination:
            result = -1 (target not found)

Example 3:
    Input: nums = [], target = 0
    Output: [-1, -1]

    Finding the Starting Index:
        Initialization:
            start = 0
            end = -1
            result = -1

        Termination:
            Array is empty, result = -1 (target not found)

    Finding the Ending Index:
        Initialization:
            start = 0
            end = -1
            result = -1

        Termination:
            Array is empty, result = -1 (target not found)
*/
