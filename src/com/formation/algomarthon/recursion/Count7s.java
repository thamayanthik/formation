package com.formation.algomarthon.recursion;

public class Count7s {
    public static void main(String[] args) {
        System.out.println(countSeven(717));
        System.out.println(countSeven(7));
        System.out.println(countSeven(123));
    }

    private static int countSeven(int n) {
        if (n == 7) {
            return 1;
        } else if (n < 9) {
            return 0;
        }

        int ans = 0;

        if (n % 10 == 7) {
            ans = 1;
        }

        return  ans + countSeven(n / 10);
    }
}
