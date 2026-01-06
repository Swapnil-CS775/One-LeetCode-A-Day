/*
Implement queue
*/

//code = 
package com.sheet;

class MyQueue{
    private int size;
    private int[] arr;
    private int front,rear;

    public MyQueue(){
        this.size=5;
        this.arr=new int[size];
        this.front=0;
        this.rear=0;
    }
    public MyQueue(int s){
        this.size=s;
        this.arr=new int[size];
        this.front=0;
        this.rear=0;
    }


    public void enQueue(int item) throws Exception {
        if(isFull()) throw new Exception();
        arr[rear++]=item;
    }

    public int deQueue() throws Exception {
        if(isEmpty())throw new Exception("Queue is empty");
        int val=arr[front++];
        if(front==rear) front=rear=0;
        return val;
    }

    public boolean isFull(){
        return rear==size;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public int peek() throws Exception {
        if(isEmpty()) throw new Exception();
        return arr[front];
    }
}

public class ImplQueue {
    public static void main(String[] args) throws Exception {
        MyQueue obj=new MyQueue();
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);

        System.out.println(obj.peek());
        obj.deQueue();
        System.out.println(obj.peek());
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.enQueue(6);
        obj.enQueue(7);
        System.out.println(obj.peek());
    }
}
