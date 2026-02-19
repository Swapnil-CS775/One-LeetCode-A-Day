/*
Queue using two Stacks
Difficulty: EasyAccuracy: 58.89%Submissions: 144K+Points: 2
Implement a Queue using 2 stacks s1 and s2 .
A Query q is of 2 Types
(i) 1 x (a query of this type means  pushing 'x' into the queue)
(ii) 2   (a query of this type means to pop element from queue and print the poped element)

Note : If there is no element return -1 as answer while popping.

Examples :

Input: q=5, queries[][]=[[1, 2], [1, 3], [2], [1, 4], [2]]
Output: [2, 3]
Explanation: 
In the first testcase
[1 2] the queue will be [2]
[1 3] the queue will be [2 3]
[2]   poped element will be 2 the queue 
will be [3]
[1 4] the queue will be [3 4]
[2 ]  poped element will be 3.
Input: q = 4, queries[][] = [[1, 2], [2], [2], [1, 4]]
Output: [2, -1]
Explanation: 
In the second testcase 
[1, 2] the queue will be [2]
[2]   poped element will be [2] and 
    then the queue will be empty
[2]   the queue is empty and hence -1
[1, 4] the queue will be [4].
Constraints:
1 <= q <= 100
1 <= x <= 100


*/

//code - 
// User function Template for Java
class StackQueue {
    Stack<Integer>s1=new Stack<>();
    
    public void push(int B) {
        // code here
        Stack<Integer>s2=new Stack<>();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(B);
        
        while(!s2.isEmpty()) s1.push(s2.pop());
        
    }

    public int pop() {
        // code here
        return s1.isEmpty() ? -1 : s1.pop();
    }
}
