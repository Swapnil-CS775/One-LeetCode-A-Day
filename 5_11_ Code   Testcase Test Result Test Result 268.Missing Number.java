/*
268. Missing Number
Solved
Easy
Topics
Companies
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
*/

//Code - 
class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length)
        {   int correct=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct])
            {
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else
            {
                i++;
            }
        }

        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=j)
            {
                return j;
            } 
        }
        return nums.length;
    }
}

// Explaination
/*
Example Walkthrough with nums = [3, 0, 1]

1. Initial State:
   nums = [3, 0, 1]
   n = 3 (since nums.length is 3)

2. First While Loop (Rearranging nums to place each number at its "correct" index):
   - Start with i = 0.

   - Iteration 1 (i = 0):
     - correct = nums[i] = 3
     - Since 3 is out of bounds (it's not less than n), increment i to 1.

   - Iteration 2 (i = 1):
     - correct = nums[i] = 0
     - nums[i] is within bounds (0 < 3) and not at its correct position (nums[1] != nums[0]).
     - Swap nums[i] and nums[correct] (swap nums[1] and nums[0]).
     - Now, nums = [0, 3, 1].

   - Iteration 3 (i = 1):
     - correct = nums[i] = 3
     - 3 is out of bounds, so increment i to 2.

   - Iteration 4 (i = 2):
     - correct = nums[i] = 1
     - nums[i] is within bounds (1 < 3) and not at its correct position (nums[2] != nums[1]).
     - Swap nums[i] and nums[correct] (swap nums[2] and nums[1]).
     - Now, nums = [0, 1, 3].

   - Iteration 5 (i = 2):
     - Now nums[i] = 3, which is out of bounds, so increment i to 3 and exit the loop.

   - After the first loop, nums = [0, 1, 3].

3. Second For Loop (Finding the Missing Number):
   - Loop through each index to see if the value matches the index.

   - Iteration 1 (j = 0):
     - nums[0] == 0, so continue.

   - Iteration 2 (j = 1):
     - nums[1] == 1, so continue.

   - Iteration 3 (j = 2):
     - nums[2] != 2, so return j = 2 as the missing number.

4. Final Output:
   - The missing number is 2, which is returned by the function.

*/
