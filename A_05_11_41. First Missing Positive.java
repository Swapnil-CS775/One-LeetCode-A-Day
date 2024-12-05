/*
41. First Missing Positive
Solved
Hard
Topics
Companies
Hint
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
*/

//Code
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1;
    }
}

//Example
/*

Given Input
nums = [7, 8, 9, 11, 12]
Goal
We want to find the smallest positive integer that is not present in the nums array.
Step-by-Step Process
Initial State:

Start with the input array: [7, 8, 9, 11, 12].
Rearranging the Array:

The first loop will rearrange the array so that if a number x is in the range 1 to n (where n is the length of the array), it will be placed at index x - 1.

For our input, the length n = 5.

Iteration through the array:

Index 0: nums[0] = 7
7 is out of range (greater than 5), so we move to the next index.
Index 1: nums[1] = 8
8 is also out of range, move to the next index.
Index 2: nums[2] = 9
9 is out of range, move to the next index.
Index 3: nums[3] = 11
11 is out of range, move to the next index.
Index 4: nums[4] = 12
12 is out of range, move to the next index.
After the first loop, the array remains unchanged: [7, 8, 9, 11, 12].

Identifying the Missing Positive Integer:

Now we check each index from 0 to n - 1 to find the first missing positive integer:

We check if nums[j] is equal to j + 1.

Check the array:

At index 0: nums[0] = 7, which is not equal to 0 + 1 (1).
At index 1: nums[1] = 8, which is not equal to 1 + 1 (2).
At index 2: nums[2] = 9, which is not equal to 2 + 1 (3).
At index 3: nums[3] = 11, which is not equal to 3 + 1 (4).
At index 4: nums[4] = 12, which is not equal to 4 + 1 (5).
Final Output:

Since none of the indices have the correct values (1 through 5), the first missing positive integer is 1, which is not present in the array.
Therefore, the output is 1.

*/
