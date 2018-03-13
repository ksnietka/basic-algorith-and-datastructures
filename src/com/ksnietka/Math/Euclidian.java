package com.ksnietka.Math;

public class Euclidian {
    public static void main(String[] args) {
        int gcd = findGreatestCommonDivision(1112, 695);
        System.out.println(gcd);
    }

    public static int findGreatestCommonDivision (int A, int B) {
        int greater = A > B ? A : B;
        int smaller = A < B ? A : B;

        while (greater % smaller != 0) {
            int modulo = greater % smaller;
            greater = smaller;
            smaller = modulo;
        }

        return smaller;
    }
}
