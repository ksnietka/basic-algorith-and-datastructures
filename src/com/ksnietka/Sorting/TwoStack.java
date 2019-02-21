package com.ksnietka.Sorting;

import com.ksnietka.DataStructures.stacks.SimpleStack;

import java.util.Arrays;

public class TwoStack<T extends Comparable<T>> {
    private SimpleStack<T> firstStack;
    private SimpleStack<T> secodStack;
    private T[] valueToSort;

    public TwoStack(T[] valueToSort) {
        firstStack = new SimpleStack<>(100);
        secodStack = new SimpleStack<>(100);
        this.valueToSort = valueToSort;
    }

    public T[] sort () {
        for (T value : valueToSort) {
            T top = firstStack.top();
            if (top == null) {
                firstStack.push(value);
                continue;
            }

            if (top.compareTo(value) <= 0) {
                firstStack.push(value);
                continue;
            }

            if (top.compareTo(value) > 0) {
                top = firstStack.top();
                while (top.compareTo(value) >= 0) {
                    secodStack.push(firstStack.pop());
                    top = firstStack.top();

                }
                firstStack.push(value);
                while (secodStack.top() != null) {
                    firstStack.push(secodStack.pop());
                }
            }
        }
        return firstStack.toArray();
    }



    public static void main(String[] args) {
        final TwoStack<Integer> integerTwoStack = new TwoStack<>(new Integer[]{1, 5, 9, 4, 10, 2, 45,2,43,54, 34});
        final Integer[] sort = (Integer[]) integerTwoStack.sort();
    }
}
