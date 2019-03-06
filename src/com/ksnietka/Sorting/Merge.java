package com.ksnietka.Sorting;

import java.util.Arrays;

public class Merge implements Sortable {
    static Comparable[] sort(Comparable[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        Comparable[] left = new Comparable[arr.length / 2];
        Comparable[] right = new Comparable[arr.length - left.length];
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, left.length, right, 0, right.length);


        //TODO: Why arrays are nullable? what repetition?
        final Comparable[] sortedLeft = removeNull(sort(left));
        final Comparable[] sortedRight = removeNull(sort(right));

        return merge(sortedLeft, sortedRight);
    }

    static Comparable[] merge(Comparable[] left, Comparable[] right) {
        Integer indexLeft = 0;
        Integer indexRight = 0;
        Integer mergeIndex = 0;
        final Comparable[] integers = new Integer[left.length + right.length];

        while(indexLeft < left.length && indexRight < right.length) {
            if(left[indexLeft].compareTo(right[indexRight]) < 0) {
                integers[mergeIndex] = left[indexLeft];
                indexLeft++;
            } else {
                integers[mergeIndex] = right[indexRight];
                indexRight++;
            }
            mergeIndex++;
        }
        while(indexRight < right.length) {
            integers[mergeIndex] = right[indexRight];
            mergeIndex++;
            indexRight++;
        }
        return integers;
    }

    static Comparable[] removeNull(Comparable[] nulled) {
        return Arrays.stream(nulled)
                .filter(s -> (s != null))
                .toArray(Comparable[]::new);
    }

    public static void main(String[] args) {
        final Integer[] integers = {2, 4, 3, 7, 1, 9, 13,3443, 5};
        System.out.print(Arrays.toString(sort(integers)));

    }


}
