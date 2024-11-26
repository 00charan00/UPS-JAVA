package com.charan.T;

public class CustomStack {
    private int[] stack;  // Array to store stack elements
    private int top;      // Index of the top element
    private int capacity; // Maximum capacity of the stack

    // Constructor to initialize the stack
    public CustomStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1; // Stack is initially empty
    }

    // Push operation: Add an element to the stack
    public void push(int element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot add more elements.");
            return;
        }
        stack[++top] = element;
        System.out.println("Pushed: " + element);
    }

    // Pop operation: Remove the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1; // Return -1 if stack is empty
        }
        return stack[top--];
    }

    // Peek operation: Retrieve the top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No top element.");
            return -1; // Return -1 if stack is empty
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Count the total number of elements in the stack
    public int count() {
        return top + 1; // Total elements = top index + 1
    }

    // Main method to test the stack
    public static void main(String[] args) {
        CustomStack myStack = new CustomStack(5);

        // Perform stack operations
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
