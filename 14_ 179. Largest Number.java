/*
 * 179. Largest Number
 * Medium
 * 
 * Runtime - 16 ms | Beats 6.82%
 * Memory - 44.88 MB | Beats 5.05%
 * 
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, you need to return a string instead of an integer.
 *
 * Example 1:
 * Input: nums = [10, 2]
 * Output: "210"
 * 
 * Example 2:
 * Input: nums = [3, 30, 34, 5, 9]
 * Output: "9534330"
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 */

// Solution
class Solution {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                String str1 = String.valueOf(nums[i]);
                String str2 = String.valueOf(nums[j]);
                String x = str1 + str2;
                String y = str2 + str1;
                if (x.compareTo(y) < 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);  // Convert each integer to a string and append
        }

        // If the largest number is '0', return "0"
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}

/*
Explanation:

The goal of the problem is to arrange the numbers in such a way that their concatenation forms the largest possible number. 

The sorting condition is key here: we compare the concatenation of two numbers in different orders (e.g., "a + b" vs. "b + a") and decide which combination leads to a larger number.

Example 1:
    Input: nums = [10, 2]
    Output: "210"

    - In the first iteration:
        - Compare nums[0] = 10 and nums[1] = 2.
        - Create two combinations:
            - "10" + "2" = "102"
            - "2" + "10" = "210"
        - Since "210" is greater than "102", we swap 10 and 2.

    After the iterations, the array becomes [2, 10].
    Final concatenation: "210"

Example 2:
    Input: nums = [3, 30, 34, 5, 9]
    Output: "9534330"

    - In the first iteration:
        - Compare "3" and "30":
            - "330" vs "303" => "330" is greater, no swap needed.

    - In the next comparisons:
        - Compare "34" and "3": 
            - "343" vs "334" => "343" is greater, swap them.

        - Compare "5" and "34": 
            - "534" vs "345" => "534" is greater, swap them.

        - Compare "9" and "5": 
            - "95" vs "59" => "95" is greater, swap them.

    After all iterations, the array becomes [9, 5, 34, 3, 30].
    Final concatenation: "9534330"

Edge Case:
    If the array contains only zeros like [0, 0], the result should be "0" instead of "00". 
    The condition `if (sb.charAt(0) == '0')` handles this case.
*/
