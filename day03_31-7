/* 
27. Remove Element
Easy
Runtime - 0ms | Beats 100%
Memory - 42.01 mb | Beats 14.58%


Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100

*/

//Solution

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int num:nums){
            if(num!=val){
                nums[count]=num;
                count++;
            }
        }
        return count; 
    }
}

//Explainnation

/*
Enhanced For Loop:
for(int num : nums): This is an enhanced for loop that iterates over each element in the nums array. In each iteration, the variable num holds the value of the current element.

    Initially, nums = [3, 2, 2, 3]
     * - Iterating over the array:
     *   - The first element is 3 (which is equal to val), so it is skipped.
     *   - The second element is 2 (which is not equal to val), so it is placed at index 0 of the array.
     *   - The third element is 2 (which is not equal to val), so it is placed at index 1 of the array.
     *   - The fourth element is 3 (which is equal to val), so it is skipped.
     * - After processing, nums = [2, 2, _, _], where _ denotes an ignored value.
     * - The new length of the array with all elements not equal to val is 2.
 */
