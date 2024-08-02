/*
3232. Find if digit game can be own
Easy
Runtime - 0ms | beats 100%
Memory - 44.30mb | beats 32.12%


 * You are given an array of positive integers nums.
Alice and Bob are playing a game. In the game, Alice can choose either all single-digit numbers or all double-digit numbers from nums, and the rest of the numbers are given to Bob. Alice wins if the sum of her numbers is strictly greater than the sum of Bob's numbers.
Return true if Alice can win this game, otherwise, return false.

Example 1:
Input: nums = [1,2,3,4,10]
Output: false
Explanation:
Alice cannot win by choosing either single-digit or double-digit numbers.

Example 2:
Input: nums = [1,2,3,4,5,14]
Output: true
Explanation:
Alice can win by choosing single-digit numbers which have a sum equal to 15.

Example 3:
Input: nums = [5,5,5,25]
Output: true
Explanation:
Alice can win by choosing double-digit numbers which have a sum equal to 25.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 99
 */

 //SOLUTION
 class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigitSum=0,doubbleDigitSum=0;
        for(int num:nums)
        {
            if(num<10)
            {
               singleDigitSum+=num;
            }
            else
            {
               doubbleDigitSum+=num;
            }
        }
        return (singleDigitSum!=doubbleDigitSum) ? true : false;
    }
}

//Explaination
/*
 * This code defines a class `Solution` with a method `canAliceWin` that determines if Alice can win a game based on the sums of single-digit and double-digit numbers in an array.
 *
 * 1. **Initialization**:
 *    - `singleDigitSum`: A variable to store the sum of all single-digit numbers in the array.
 *    - `doubleDigitSum`: A variable to store the sum of all double-digit numbers in the array.
 *
 * 2. **Iteration through the array**:
 *    - The `for` loop iterates through each number in the input array `nums`.
 *    - If the number is a single-digit number (less than 10), it is added to `singleDigitSum`.
 *    - If the number is a double-digit number (10 or greater), it is added to `doubleDigitSum`.
 *
 * 3. **Return Condition**:
 *    - The method returns `true` if the sums of single-digit numbers and double-digit numbers are not equal (`singleDigitSum != doubleDigitSum`).
 *    - This condition checks whether Alice's chosen strategy (choosing either all single-digit numbers or all double-digit numbers) results in a different sum compared to Bob's sum, but it does not guarantee Alice's win based on the problem requirements.
 *    - The problem requires checking if Alice's sum is strictly greater than Bob's sum in either case, which is not fully addressed by this implementation.
 */
