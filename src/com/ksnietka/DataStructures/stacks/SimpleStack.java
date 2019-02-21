package com.ksnietka.DataStructures.stacks;

public class SimpleStack <T> {
    private T[] values;
    private int stackSize;
    private int top = 0;
    @SuppressWarnings("unchecked")
    public SimpleStack(int stackSize) {
        this.stackSize = stackSize;
        values =  (T[]) new Object[stackSize];
    }

    public void push(T value) {
        if (top == stackSize - 1)
                throw new StackOverflowError();
        values[++top] = value;
    }

    public T pop() {
        if (top < 0)
            return null;
        T value = values[top--];

        return value;
    }
    public T[] toArray () {
        return values;
    }

    public T top() {
        if (top == 0) return null;
        return values[top];
    }

    public static void main(String[] args) {
        final SimpleStack<String> stringSimpleStack = new SimpleStack<>(5);

        stringSimpleStack.push("aaa");
        stringSimpleStack.push("bbb");
        stringSimpleStack.push("ccc");

        System.out.println(stringSimpleStack.pop());
        stringSimpleStack.push("ddd");
        stringSimpleStack.push("eee");
        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());

        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());
        stringSimpleStack.push("fff");
        stringSimpleStack.push("hhh");
        System.out.println(stringSimpleStack.top());
        System.out.println(stringSimpleStack.pop());
        System.out.println(stringSimpleStack.pop());
    }
}
