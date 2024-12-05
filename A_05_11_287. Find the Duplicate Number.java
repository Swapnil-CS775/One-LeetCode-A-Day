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

//Code
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correct = nums[i] - 1;
                if (nums[i] != nums[correct]) {
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                }
                else {
                    return nums[i];
                }
            }
            else {
                i++;
            }
        }
        return -1;
    }
}

/*
Example

Explanation with Example nums = [1, 3, 4, 2, 2]
Initial State:

Input array: nums = [1, 3, 4, 2, 2]
Start with index i = 0.
While Loop (Placing Elements in Correct Positions):

The loop aims to place each number at its "correct" index, meaning the number n should be at index n - 1.

Step-by-Step Execution:

Iteration 1 (i = 0):

nums[i] = 1, which is at its correct position (index 0).
Increment i to 1.
Iteration 2 (i = 1):

nums[i] = 3, the correct index for 3 is 2 (3 - 1).
nums[1] (3) is not equal to nums[2] (4), so we swap nums[1] and nums[2].
After the swap, nums becomes [1, 4, 3, 2, 2].
Iteration 3 (i = 1) (continue with the new value at index 1):

Now, nums[i] = 4, the correct index for 4 is 3 (4 - 1).
nums[1] (4) is not equal to nums[3] (2), so we swap nums[1] and nums[3].
After the swap, nums becomes [1, 2, 3, 4, 2].
Iteration 4 (i = 1) (continue with the new value at index 1):

Now, nums[i] = 2, the correct index for 2 is 1 (2 - 1).
nums[1] (2) is equal to nums[1] (2), indicating we have found the duplicate number.
The duplicate number 2 is returned immediately.
Return Value:

The function returns 2 as the duplicate number found in the input array.
*/
