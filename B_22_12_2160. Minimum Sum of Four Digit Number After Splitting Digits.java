/*
2160. Minimum Sum of Four Digit Number After Splitting Digits
Solved
Easy
Topics
Companies
Hint
You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2 by using the digits found in num. Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.

For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
Return the minimum possible sum of new1 and new2.

 

Example 1:

Input: num = 2932
Output: 52
Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
Example 2:

Input: num = 4009
Output: 13
Explanation: Some possible pairs [new1, new2] are [0, 49], [490, 0], etc. 
The minimum sum can be obtained by the pair [4, 9]: 4 + 9 = 13.
 

Constraints:

1000 <= num <= 9999

*/


//Code - 
class Solution {
    public int minimumSum(int num) {
        int[] digits=new int[4];

        for(int i=0;i<4;i++)
        {
            int arrayDigit=num%10;
            num=num/10;
            digits[i]=arrayDigit;
        }
        Arrays.sort(digits);

        if(digits[0]==0 && digits[1]==0) return digits[2]+digits[3];

        StringBuilder completeNumber1 = new StringBuilder();
        StringBuilder completeNumber2 = new StringBuilder();
        completeNumber1.append(digits[0]);
        completeNumber1.append(digits[2]);
        completeNumber2.append(digits[1]);
        completeNumber2.append(digits[3]);
    return Integer.parseInt(String.valueOf(completeNumber1))+Integer.parseInt(String.valueOf(completeNumber2));
    }

    
}


// Ans 2 - 
class Solution {
    public int minimumSum(int num) {
        int[] digits=new int[4];

        for(int i=0;i<4;i++)
        {
            int arrayDigit=num%10;
            num=num/10;
            digits[i]=arrayDigit;
        }
        Arrays.sort(digits);

        if(digits[0]==0 && digits[1]==0) return digits[2]+digits[3];

        int new1 = digits[0] * 10 + digits[2]; // Combine the smallest and third smallest
        int new2 = digits[1] * 10 + digits[3]; // Combine the second smallest and largest

    return new1+new2;
    }

    
}
