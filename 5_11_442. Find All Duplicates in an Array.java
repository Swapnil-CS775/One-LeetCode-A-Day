/*
442. Find All Duplicates in an Array
Solved
Medium
Topics
Companies
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.
*/

//Code
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i=0;
        List<Integer>myList=new ArrayList<>();
        while(i<nums.length)
        {
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct])
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
            if(nums[j]!=j+1)
            {
                int correc=nums[j]-1;
                if(nums[j]==nums[correc])
                {
                    myList.add(nums[j]);
                }
            }
        }
    return myList;
    }
}

//Example

/*
### Example Explanation

#### Given Input
nums = [4, 3, 2, 7, 8, 2, 3, 1]

#### Step-by-Step Process

1. **Initial State**:
   - We start with the input array: [4, 3, 2, 7, 8, 2, 3, 1].

2. **Rearranging the Array**:
   - The goal is to rearrange the array so that each number `x` is placed at index `x-1`.
   - We use a loop to do this:

   - **First Iteration (i = 0)**:
     - Current number: 4
     - Correct position for 4 is 3 (index `4-1`).
     - Swap nums[0] and nums[3]:
     [7, 3, 2, 4, 8, 2, 3, 1]

   - **Second Iteration (i = 0)**:
     - Current number: 7
     - Correct position for 7 is 6 (index `7-1`).
     - Swap nums[0] and nums[6]:
     [3, 3, 2, 4, 8, 2, 7, 1]

   - **Third Iteration (i = 0)**:
     - Current number: 3
     - Correct position for 3 is 2 (index `3-1`).
     - Swap nums[0] and nums[2]:
     [2, 3, 3, 4, 8, 2, 7, 1]

   - **Fourth Iteration (i = 0)**:
     - Now nums[0] is 2, and it’s already in its correct position.
     - Increment `i` to `1`.

   - **Continue Iterating** until all numbers are in their correct positions.

   - After rearranging, the final state of the array will be:
   [1, 2, 3, 4, 5, 2, 6, 7]

3. **Identifying Duplicates**:
   - Now, we check each index from `0` to `n-1`:
   - For each index `j`, if `nums[j]` is not equal to `j + 1`, then it's a duplicate.
   
   - **Check the array**:
     - At index `5`: nums[5] = 2, which is not equal to `5 + 1` (6).
       - Check if nums[5] is equal to nums[2] (the correct index):
       nums[5] == nums[2] => 2 == 2 (true)
       - Add 2 to myList.

     - At index `2`: nums[2] = 3, which is not equal to `2 + 1` (3).
       - Check if nums[2] is equal to nums[2] (the correct index):
       nums[2] == nums[2] => 3 == 3 (true)
       - Add 3 to myList.

4. **Final Output**:
   - The duplicates found are: [2, 3].

*/
