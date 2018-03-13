package com.ksnietka.Sorting;

public class Selection implements Sortable {
    public static void main(String[] args) {
        Integer[] toSort = {4, 1, 43, 32, 3, 7};
        for(Integer i: sort(toSort)) {
            System.out.println(i);
        }

    }

    public static Integer[] sort  (Integer[] arrayToSort) {
        for (Integer i = 0; i < arrayToSort.length - 1; i++) {
            Integer index = i;
            for (Integer j = i; j < arrayToSort.length; j++) {
                if (arrayToSort[index] > arrayToSort[j]) {
                    index = j;
                }
            }
            Integer smallerNum = arrayToSort[index];
            arrayToSort[index] = arrayToSort[i];
            arrayToSort[i] = smallerNum;

        }
        return arrayToSort;
    }

}
