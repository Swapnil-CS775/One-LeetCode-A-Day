/*
2595. Number of Even and Odd Bits
Solved
Easy
Topics
Companies
Hint
You are given a positive integer n.

Let even denote the number of even indices in the binary representation of n with value 1.

Let odd denote the number of odd indices in the binary representation of n with value 1.

Note that bits are indexed from right to left in the binary representation of a number.

Return the array [even, odd].

 

Example 1:

Input: n = 50

Output: [1,2]

Explanation:

The binary representation of 50 is 110010.

It contains 1 on indices 1, 4, and 5.

Example 2:

Input: n = 2

Output: [0,1]

Explanation:

The binary representation of 2 is 10.

It contains 1 only on index 1.

 

Constraints:

1 <= n <= 1000
*/

//brute force approch - 
class Solution {
    public int[] evenOddBit(int n) {
        int even=0,odd=0;
        StringBuilder binary=new StringBuilder();
        while (n!=0)
        {
            int ans=n%2;
            n=n/2;
            binary.append(ans);
        }
        int i=0;
        while(i<binary.length()){
            char bit=binary.charAt(i);
            System.out.println(bit);
            if(bit=='1')
            {
                if((i & 1)==1)
                {
                    odd++;
                }
                else
                {
                    even++;
                }
            }
            i++;
        }
        return new int[]{even,odd};
    }
}


//optimized approch- 
class Solution {
    public int[] evenOddBit(int n) {
        int even=0,odd=0,idx=0;
        while (n>0){
            if((n & 1)==1){
                if(idx % 2==0) even++;
                else odd++;
            }
            n>>=1;
            idx++;
        }
        return new int[]{even,odd};
    }
}
