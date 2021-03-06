package com.ksnietka.DataStructures.stacks;

import java.util.Iterator;
import java.util.function.Consumer;

public class ResizableStack <T> {
    private T[] values;
    private int defaultStackSize = 10;
    private int top = -1;
    @SuppressWarnings("unchecked")
    public ResizableStack() {
        values =  (T[]) new Object[defaultStackSize];
    }

    public void push(T value) {
        if(isFull()) resize(values.length * 2 );
        values[++top] = value;
    }

    private boolean isFull() {
        return top == values.length - 1;
    }

    public T pop() {

        if (top < 0)
            return null;
        if(top == values.length / 4) resize(values.length/ 2);
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

    private void resize(int size) {
        T[] tempArray = (T[]) new Object[size];
        for (int i = 0; i < top + 1; i++) {
            tempArray[i] = values[i];
        }
        values = tempArray;
    }


    public Iterator<T> iterator () {
        return new ReverseArrayIterator();

    }

    private class ReverseArrayIterator implements Iterator<T> {
        int i = top;
        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return values[--i];

        }
    }
}
