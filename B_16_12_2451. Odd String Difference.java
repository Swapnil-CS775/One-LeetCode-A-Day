/*
2451. Odd String Difference
Solved
Easy
Topics
Companies
Hint
You are given an array of equal-length strings words. Assume that the length of each string is n.

Each string words[i] can be converted into a difference integer array difference[i] of length n - 1 where difference[i][j] = words[i][j+1] - words[i][j] where 0 <= j <= n - 2. Note that the difference between two letters is the difference between their positions in the alphabet i.e. the position of 'a' is 0, 'b' is 1, and 'z' is 25.

For example, for the string "acb", the difference integer array is [2 - 0, 1 - 2] = [2, -1].
All the strings in words have the same difference integer array, except one. You should find that string.

Return the string in words that has different difference integer array.

 

Example 1:

Input: words = ["adc","wzy","abc"]
Output: "abc"
Explanation: 
- The difference integer array of "adc" is [3 - 0, 2 - 3] = [3, -1].
- The difference integer array of "wzy" is [25 - 22, 24 - 25]= [3, -1].
- The difference integer array of "abc" is [1 - 0, 2 - 1] = [1, 1]. 
The odd array out is [1, 1], so we return the corresponding string, "abc".
Example 2:

Input: words = ["aaa","bob","ccc","ddd"]
Output: "bob"
Explanation: All the integer arrays are [0, 0] except for "bob", which corresponds to [13, -13].
 

Constraints:

3 <= words.length <= 100
n == words[i].length
2 <= n <= 20
words[i] consists of lowercase English letters.

*/

//Code - 
class Solution {
    public String oddString(String[] words) {
        // Create a map to store difference arrays and their counts
        Map<String, List<String>> diffMap = new HashMap<>();
        
        for (String word : words) {
            // Generate the difference array for the word
            int[] diffArray = getDifferenceArray(word);
            // Convert the array to a string for easy comparison
            String diffKey = Arrays.toString(diffArray);
            
            // Add the word to the map under its difference array
            diffMap.putIfAbsent(diffKey, new ArrayList<>());
            diffMap.get(diffKey).add(word);
        }
        
        // Find the key with only one word associated with it
        for (Map.Entry<String, List<String>> entry : diffMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getValue().get(0); // Return the unique word
            }
        }
        
        return ""; // Default return (this shouldn't happen based on constraints)
    }
    
    // Helper function to compute the difference array for a string
    private int[] getDifferenceArray(String word) {
        int n = word.length();
        int[] diffArray = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffArray[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diffArray;
    }
}
