/*
implement a stack from scratch
*/

//code 
package com.sheet;

import java.util.EmptyStackException;

class MyStack{
    protected int[] arr;
    protected int size=5;
    protected int top;

    public MyStack(int s){
        this.size=s;
        this.top=-1;
        this.arr=new int[size];
    }

    public MyStack(){
        this.top=-1;
        this.arr=new int[size];
    }

    public void push(int item) throws Exception {
        if(isFull()) throw new Exception();
        arr[++top]=item;
    }

    public int pop() throws Exception {
        if(isEmpty()) throw new Exception();
        return arr[top--];
    }

    public int peek() throws Exception {
        if(isEmpty()) throw new Exception();
        return arr[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==size-1;
    }
}

class Advance extends MyStack{
    @Override
    public void push(int item) throws Exception {
        if(isFull()){
            //double the size and add
            int[] temp=new int[size*2];
            int i=-1;
            for(int ele:arr){
                temp[++i]=ele;
            }
            size=top*2;
            top=i;
            arr=temp;
        }
        super.push(item);
    }
}

public class ImplStack {
    public static void main(String[] args) throws Exception {
//        MyStack obj=new MyStack();
//        obj.push(5);
//        obj.push(8);
//        obj.pop();
//        System.out.println(obj.peek());

        Advance obj1=new Advance();
        obj1.push(1);
        obj1.push(2);
        obj1.push(3);
        obj1.push(4);
        obj1.push(5);
        System.out.println(obj1.peek());
        obj1.push(6);
        System.out.println(obj1.peek());
        obj1.push(9);
        System.out.println(obj1.peek());
        obj1.pop();
        System.out.println(obj1.peek());

    }
}
