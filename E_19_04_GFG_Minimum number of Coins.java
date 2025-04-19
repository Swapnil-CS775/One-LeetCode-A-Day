/*
Minimum number of Coins
Difficulty: EasyAccuracy: 51.25%Submissions: 82K+Points: 2
Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. 


Example 1:

Input: N = 43
Output: 20 20 2 1
Explaination: 
Minimum number of coins and notes needed 
to make 43. 

Example 2:

Input: N = 1000
Output: 500 500
Explaination: minimum possible notes
is 2 notes of 500.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minPartition() which takes the value N as input parameter and returns a list of integers in decreasing order.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 106


*/

//code - 
class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        int[] options={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        return minNoOfCoins2(options,N);
    }
    static ArrayList<Integer> minNoOfCoins2(int[] arr,int coin){
        ArrayList<Integer>list=new ArrayList<>();
        int i=arr.length-1;
        while(coin!=0){
            while (coin/arr[i]<=0) i--;
            int times=coin/arr[i];
            while(times!=0) {
                list.add(arr[i]);
                times--;
            }
            coin=coin%arr[i];
        }
        return list;
    }
}
