package com.ksnietka.Sorting;

public class Bubble implements Sortable{
    public static void main(String[] args) {
        Integer[] example = {2,4, 1, 3,43,12,3};
        for(Integer a: sort(example)) {
            System.out.println(a);
        }
    }

    public static Integer[] sort (Integer[] array) {
        Integer length = array.length - 1;
        Integer temp;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j+ 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;

    }
}
