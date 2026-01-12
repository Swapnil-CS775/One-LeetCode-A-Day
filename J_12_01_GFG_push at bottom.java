
//Q. push at bottom


package com.sheet;

import java.util.Stack;

public class InsertAtBottom {
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();

        System.out.println(stack);
        question(stack,1);
        System.out.println(stack);
        question(stack,2);
        System.out.println(stack);
        question(stack,3);
        System.out.println(stack);
        question(stack,4);
        System.out.println(stack);
        question(stack,5);
        System.out.println(stack);
    }

    public static void question(Stack<Integer>stack,int data){
        if (stack.isEmpty()){
            stack.push(data);
        }else{
            int currVal=stack.pop();
            question(stack,data);
            stack.push(currVal);
        }
    }
}

/*
    this is normal stack
*   5
*   4
*   3
*   2
*   1
*
    this will be our stack
    1
    2
    3
    4
    5
* */
