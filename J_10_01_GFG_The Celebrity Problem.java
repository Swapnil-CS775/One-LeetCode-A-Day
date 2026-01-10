/*
The Celebrity Problem
Difficulty: MediumAccuracy: 38.33%Submissions: 359K+Points: 4Average Time: 30m
A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0],
                [0, 1, 0],
                [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person and 1st person does not know anyone. Therefore, 1 is the celebrity person.
Input: mat[][] = [[1, 1], 
                [1, 1]]
Output: -1
Explanation: Since both the people at the party know each other. Hence none of them is a celebrity person.
Input: mat[][] = [[1]]
Output: 0
Constraints:
1 ≤ mat.size() ≤ 1000
0 ≤ mat[i][j] ≤ 1
mat[i][i] = 1


*/

//first appraoch in O(n^2 )
class Solution {
    public int celebrity(int mat[][]) {
        for(int i=0;i<mat.length;i++){
            if(isRowOk(mat,i)){
                if(isColOk(mat,i)) return i;
            }
        }
        return -1;
    }
    
    public boolean isRowOk(int[][] mat,int i){
        for(int k=0;k<mat[i].length;k++){
            if(mat[i][k]==1 && i!=k) return false;
        }
        return true;
    }
    
    public boolean isColOk(int[][] mat,int j){
        for(int i=0;i<mat.length;i++){
            if(mat[i][j]==0) return false;
        }
        return true;
    }
}


//second approach usign stack in O(n)

class Solution {
    public int celebrity(int mat[][]) {
        Stack<Integer>stack=new Stack<>();
        
        for(int i=0;i<mat.length;i++) stack.push(i);
        
        while(stack.size()>1){
            int a=stack.pop();
            int b=stack.pop();
            
            if(mat[a][b]==1) stack.push(b);
            else stack.push(a);
            
            if(stack.size()==1){
                int cad=stack.peek();
                boolean rowValid=true,colValid=true;
                for(int i=0;i<mat[cad].length;i++){
                    if(i!= cad && mat[cad][i]==1){
                        rowValid=false;
                        break;
                    } 
                }
                
                for(int i=0;i<mat.length;i++){
                    if(mat[i][cad]!=1){
                        colValid=false;
                        break;
                    }
                }
                
                if(rowValid && colValid) return stack.peek();
                else return -1;
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
