/*
 * 66 Plus One
 * Easy 
 * Runtime - 0ms | Beats 100%
 * Memory - 41.49 MB | Beats 88.95%
 * 
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 
 */

//Solution

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}


//Explaination

/*
 * Example 1:
     * Input: digits = [1, 2, 3]
     * Process:
     * - Starting from the last digit (3), increment it to 4.
     * - No carry-over is needed, so the result is [1, 2, 4].
     * Output: [1, 2, 4]
     * 
     * Example 2:
     * Input: digits = [4, 3, 2, 1]
     * Process:
     * - Starting from the last digit (1), increment it to 2.
     * - No carry-over is needed, so the result is [4, 3, 2, 2].
     * Output: [4, 3, 2, 2]
     * 
     * Example 3:
     * Input: digits = [9]
     * Process:
     * - Starting from the last digit (9), set it to 0 (carry-over).
     * - Since there are no more digits to process, create a new array of size 2.
     * - Set the first element of the new array to 1, resulting in [1, 0].
     * Output: [1, 0]
     * 
 */


