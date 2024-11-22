/*
12. Integer to Roman
Solved
Medium
Topics
Companies
Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.

 

Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
 8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
 900 = CM
  90 = XC
   4 = IV
 

Constraints:

1 <= num <= 3999

*/

//Code - Bruitforce approch
class Solution {
    public String intToRoman(int num) {
        int remainder=-1,qutient=0;
        StringBuilder ans=new StringBuilder("");

        while(remainder!=0)
        {
            int baseVal=findBaseVal(num);
            remainder=num%baseVal;
            qutient=num/baseVal;

            for(int i=0;i<qutient;i++)
            {
                ans.append(findSymbol(baseVal));
            }
            num=remainder;
        }
    return ans.toString();
    }

    public int findBaseVal(int number)
    {
        if(number>=1000)
            return 1000;
        else if(number>=900 && number<1000)
            return 900;
        else if(number>=500 && number<900)
            return 500;
        else if(number>=400 && number<500)
            return 400;
        else if(number>=100 && number<400)
            return 100;
        else if(number>=90 && number<100)
            return 90;
        else if(number>=50 && number<90)
            return 50;
        else if(number>=40 && number<50)
            return 40;
        else if(number>=10 && number<40)
            return 10;
        else if(number==9)
            return 9;
        else if(number>=5 && number<9)
            return 5;
        else if(number==4)
            return 4;
        else
            return 1;
    }

    public String findSymbol(int value)
    {
        if(value==1000)
            return "M";
        else if(value==900)
            return "CM";
        else if(value==500)
            return "D";
        else if(value==400)
            return "CD";
        else if(value==100)
            return "C";
        else if(value==90)
            return "XC";
        else if(value==50)
            return "L";
        else if(value==40)
            return "XL";
        else if(value==10)
            return "X";
        else if(value==9)
            return "IX";
        else if(value==5)
            return "V";
        else if(value==4)
            return "IV";
        else if(value==1)
            return "I";
        else
            return "";
    }
}

/*
Explanation:

Step 1

Initially number = 3549
Since 3549 >= 1000 ; largest base value will be 1000 initially.
Divide 3549/1000. Quotient = 3, Remainder =549. The corresponding symbol M will be repeated thrice.
We append the Result value in the 2nd List.
Now Remainder is not equal to 0 so we call the function again.
Step 2

Now, number = 549
1000 > 549 >= 500 ; largest base value will be 500.
Divide 549/500. Quotient = 1, Remainder =49. The corresponding symbol D will be repeated once & stop the loop.
We append the Result value in the 2nd List.
Now Remainder is not equal to 0 so we call the function again.
Step 3

Now, number = 49
50 > 49 >= 40 ; largest base value is 40.
Divide 49/40. Quotient = 1, Remainder = 9. The corresponding symbol XL will be repeated once & stop the loop.
We append the Result value in the 2nd List.
Now Remainder is not equal to 0 so we call the function again.
Step 4

Now, number = 9
Number 9 is present in list ls so we directly fetch the value from dictionary dict and set Remainder=0 & stop the loop.
Remainder = 0. The corresponding symbol IX will be repeated once and now remainder value is 0 so we will not call the function again.
Step 5

Finally, we join the 2nd list values.
The output obtained MMMDXLIX.

*/

//Let's try for optimized approch

class Solution {
    public String intToRoman(int num) {
        // Array of Roman numeral values and their corresponding symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder ans = new StringBuilder();

        // Loop through each value-symbol pair
        for (int i = 0; i < values.length && num > 0; i++) {
            int quotient = num / values[i]; // Determine how many times the current value fits into `num`
            if (quotient > 0) {
                ans.append(symbols[i].repeat(quotient)); // Append the corresponding symbol `count` times
                num %= values[i]; // Reduce `num` by the current value
            }
        }

        return ans.toString();
    }
}



