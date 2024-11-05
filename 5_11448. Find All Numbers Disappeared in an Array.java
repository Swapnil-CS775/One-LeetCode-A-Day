/*
448. Find All Numbers Disappeared in an Array
Solved
Easy
Topics
Companies
Hint
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


*/
//Code
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
               myList.add(j+1);
            }
        }
    return myList;
    }
}

/*
Example

Code Walkthrough for nums = [4,3,2,7,8,2,3,1]
Initial State:

Input array: nums = [4, 3, 2, 7, 8, 2, 3, 1]
An empty list myList is created to store the missing numbers.
First While Loop (Rearranging the Array):

The goal of this loop is to place each number at its "correct" index, where the number n should be placed at index n-1.

We go through each element in nums using index i and perform swaps as needed until each element is either in its correct place or out of range.

Step-by-Step Rearrangement:

Iteration 1 (i = 0): nums[i] = 4
Correct index for 4 is 3 (since 4 - 1 = 3).
Swap nums[0] and nums[3] → nums becomes [7, 3, 2, 4, 8, 2, 3, 1].
Iteration 2 (i = 0): nums[i] = 7
Correct index for 7 is 6.
Swap nums[0] and nums[6] → nums becomes [3, 3, 2, 4, 8, 2, 7, 1].
Iteration 3 (i = 0): nums[i] = 3
Correct index for 3 is 2.
Swap nums[0] and nums[2] → nums becomes [2, 3, 3, 4, 8, 2, 7, 1].
Iteration 4 (i = 0): nums[i] = 2
Correct index for 2 is 1.
Swap nums[0] and nums[1] → nums becomes [3, 2, 3, 4, 8, 2, 7, 1].
Iteration 5 (i = 0): nums[i] = 3
Correct index for 3 is 2, but nums[2] is already 3, so increment i to 1.
Iterations 6-7 (i = 1 to 7): Continue rearranging using similar swaps until nums is [1, 2, 3, 4, 3, 2, 7, 8].
Second For Loop (Identifying Missing Numbers):

Now, we loop through each index j to find the indices where numbers are missing.

For each j, if nums[j] != j + 1, it means the number j + 1 is missing from the array.

Step-by-Step Check:

Iteration 1 (j = 0): nums[0] = 1, which is correct.
Iteration 2 (j = 1): nums[1] = 2, which is correct.
Iteration 3 (j = 2): nums[2] = 3, which is correct.
Iteration 4 (j = 3): nums[3] = 4, which is correct.
Iteration 5 (j = 4): nums[4] = 3, which is incorrect → Add j + 1 = 5 to myList.
Iteration 6 (j = 5): nums[5] = 2, which is incorrect → Add j + 1 = 6 to myList.
Iteration 7 (j = 6): nums[6] = 7, which is correct.
Iteration 8 (j = 7): nums[7] = 8, which is correct.
After the loop, myList contains [5, 6].

Final Output:

Return myList as the result.
Output: [5, 6]

*/
