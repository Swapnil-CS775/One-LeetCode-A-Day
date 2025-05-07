/*
52. N-Queens II
Solved
Hard
Topics
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
*/


//soln - 
class Solution {
    public int totalNQueens(int n) {
        String[][] bord = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bord[i][j] = "*";
            }
        }

        return queens(bord, 0);
    }

    public int queens(String[][] bord, int row) {
        if (row == bord.length)
            return 1;

        int count = 0;
        for (int i = 0; i < bord[0].length; i++) {
            if (isValidPosition(bord, row, i)) {
                bord[row][i] = "Q";
                count = count + queens(bord, row + 1);
                bord[row][i] = "*";
            }
        }
        return count;
    }

    public boolean isValidPosition(String[][] bord, int row, int column) {

        int localR = row, localC = column;
        //lets check for upword
        while (localR >= 0) {
            if (bord[localR][localC] != "*")
                return false;
            localR--;
        }

        localR = row;
        localC = column;
        //lets check for left diagonal 
        while (localR >= 0 && localC >= 0) {
            if (bord[localR][localC] != "*")
                return false;
            localR--;
            localC--;
        }

        localR = row;
        localC = column;
        //lets check for right diagonal 
        while (localR >= 0 && localC < bord[0].length) {
            if (bord[localR][localC] != "*")
                return false;
            localR--;
            localC++;
        }

        return true;
    }
}
