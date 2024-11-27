package com.charan.T;

public class CustomStack {
    private int[] stack;
    private int top;
    private int capacity;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot add more elements.");
            return;
        }
        stack[++top] = element;
        System.out.println("Pushed: " + element);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No top element.");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int count() {
        return top + 1;
    }

    public static void main(String[] args) {
        CustomStack myStack = new CustomStack(5);

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println("Top element: " + myStack.peek());
        System.out.println("Is stack empty? " + myStack.isEmpty());
        System.out.println("Total elements in stack: " + myStack.count());

        System.out.println("Popped: " + myStack.pop());
        System.out.println("Top element after pop: " + myStack.peek());
        System.out.println("Total elements after pop: " + myStack.count());

        System.out.println("Is stack empty? " + myStack.isEmpty());
    }
}
