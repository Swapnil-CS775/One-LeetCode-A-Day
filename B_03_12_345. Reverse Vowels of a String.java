/*
345. Reverse Vowels of a String
Solved
Easy
Topics
Companies
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

//First approch - 
class Solution {
    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        char[] charArray=s.toCharArray();

        while (i <= j) {
            if(isVowels(charArray[i]) && isVowels(charArray[j]))
            {
                char temp=charArray[i];
                charArray[i]=charArray[j];
                charArray[j]=temp;
                i++;
                j--;
                continue;
            }
            else if (!isVowels(charArray[i])) {
                i++;
            } else if (!isVowels(charArray[j])) {
                j--;
            }
        }

        return new String(charArray);
    }

    public boolean isVowels(char ch)
    {
        return "aeiouAEIOU".indexOf(ch) !=-1;
    }
}

// sec approch

class Solution {
    private static final Set<Character> vowels = new HashSet<>();

    // Initialize the set of vowels (this runs only once)
    static {
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            if (vowels.contains(chars[i]) && vowels.contains(chars[j])) {
                // Swap vowels
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (!vowels.contains(chars[i])) {
                i++;
            } else {
                j--;
            }
        }

        return new String(chars);
    }
}
