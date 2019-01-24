package com.ksnietka.conversion;

public class StringToInt {
    public static int conver(String str) {
        final char[] chars = str.toCharArray();
        int number = 0;
        int len = chars.length;



        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                number = -number;
                break;
            }
            number += Math.pow(10, len - i -1) * (chars[i] - 48);

        }
        return number;
    }


    public static void main(String[] args) {
        System.out.print(conver("109020"));
    }
}
