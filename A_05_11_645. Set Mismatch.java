/*
645. Set Mismatch
Solved
Easy
Topics
Companies
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
*/

//Code

class Solution {
    public int[] findErrorNums(int[] nums) {
        int i=0;
        int[] ans=new int[2];
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
                i++;
        }

        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=j+1)
            {
                int correc=nums[j]-1;
                if(nums[j]==nums[correc])
                {
                    ans[0]=nums[j];
                    ans[1]=j+1;
                }
            }
        }
    return ans;
    }
}

//Example

/*
### Example Explanation

#### Given Input
nums = [1, 2, 2, 4]

#### Step-by-Step Process

1. **Initial State**:
   - We start with the input array: [1, 2, 2, 4].
   - The original set should contain all integers from 1 to 4, which are [1, 2, 3, 4].

2. **Rearranging the Array**:
   - We need to rearrange the array such that each number `x` is placed at index `x-1`.
   - We use a loop to do this:

   - **First Iteration (i = 0)**:
     - Current number: 1
     - Correct position for 1 is 0 (index `1-1`).
     - Since nums[0] is already in the correct position, increment `i` to `1`.

   - **Second Iteration (i = 1)**:
     - Current number: 2
     - Correct position for 2 is 1 (index `2-1`).
     - Since nums[1] is already in the correct position, increment `i` to `2`.

   - **Third Iteration (i = 2)**:
     - Current number: 2
     - Correct position for 2 is 1 (index `2-1`).
     - Since nums[2] (which is 2) is not equal to nums[1] (which is also 2), we have a duplicate. We swap nums[2] and nums[1]:
     - After swapping, the array remains: [1, 2, 2, 4].

   - **Fourth Iteration (i = 2)**:
     - Now, nums[2] is still 2. It’s in the wrong position (it should be 3 at index 2).
     - The loop continues until we complete the rearranging process.

   - Final state after rearranging might look like: [1, 2, 4, 2].

3. **Identifying the Duplicate and Missing Number**:
   - Now, we check each index from `0` to `n-1` (0 to 3 in this case):
   - For each index `j`, if `nums[j]` is not equal to `j + 1`, we can determine the duplicate and the missing number.

   - **Check the array**:
     - At index `0`: nums[0] = 1, which is equal to `0 + 1` (1).
     - At index `1`: nums[1] = 2, which is equal to `1 + 1` (2).
     - At index `2`: nums[2] = 4, which is not equal to `2 + 1` (3).
       - So, we have found that 4 is in the wrong position, indicating that 3 is missing.
       - The duplicate found earlier is 2.
     - At index `3`: nums[3] = 2, which is not equal to `3 + 1` (4).

4. **Final Output**:
   - The duplicate found is: 2.
   - The missing number is: 3.
   - Therefore, the output is [2, 3].

*/
