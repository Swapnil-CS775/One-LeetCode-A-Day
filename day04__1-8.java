/*
35. Search Insert Position
Easy
Runtime - 0ms | beats 100%
Memory - 42.87 | beats 43.36%

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

//Solution

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(high+low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}

//Explaination
/*
 * The method uses binary search to find the appropriate index.
     * 
     * Example 1:
     * Input: nums = [1, 3, 5, 6], target = 5
     * Process:
     * - Initialize low = 0 and high = 3 (length of nums - 1).
     * - Calculate mid = (0 + 3) / 2 = 1.
     * - nums[mid] = nums[1] = 3.
     * - Since 3 < 5, update low to mid + 1 = 2.
     * - Calculate mid = (2 + 3) / 2 = 2.
     * - nums[mid] = nums[2] = 5.
     * - Since 5 == 5, return mid = 2.
     * Output: 2
     * 
     * Example 2:
     * Input: nums = [1, 3, 5, 6], target = 2
     * Process:
     * - Initialize low = 0 and high = 3.
     * - Calculate mid = (0 + 3) / 2 = 1.
     * - nums[mid] = nums[1] = 3.
     * - Since 3 > 2, update high to mid - 1 = 0.
     * - Calculate mid = (0 + 0) / 2 = 0.
     * - nums[mid] = nums[0] = 1.
     * - Since 1 < 2, update low to mid + 1 = 1.
     * - low > high, loop ends.
     * - Return low = 1 (position where 2 should be inserted).
     * Output: 1
 */
