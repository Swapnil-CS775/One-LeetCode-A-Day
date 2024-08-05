/*
 * 121. Best Time to Buy and Sell Stock
 * Easy
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

// Brute Force Approach
// Note: This approach is not acceptable due to Time Limit Exceeded
//Runtime: 2464 ms

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++) {
            for(int j=i+1;j<prices.length;j++) {
                if(prices[j]-prices[i]>maxProfit) {
                   maxProfit=prices[j]-prices[i];
                }
            }
        }
        return maxProfit;
    }
}

// Explanation
/*
This brute force solution checks every possible pair of buy and sell days to calculate the maximum possible profit.
For each day 'i' as the buy day, it checks every subsequent day 'j' as the sell day to find the profit.
If the calculated profit is greater than the current maxProfit, it updates maxProfit.
The time complexity of this solution is O(n^2), which is not efficient for large input sizes, leading to Time Limit Exceeded (TLE) errors.
*/
