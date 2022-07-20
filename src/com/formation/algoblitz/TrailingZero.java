package com.formation.algoblitz;

public class TrailingZero {
    public static void main(String[] str) {
        System.out.println(trailingZeroes2(28));
    }

    public static int trailingZeroes(int n) {
        if (n == 0) return 0;

        int result = 0;
        int x = 5;

        while (x <= n) {
            result += n/x;
            x *= 5;
        }


        return result;
    }

    public static int trailingZeroes2(int n) {
        if (n == 0) return 0;

        int result = 0;
        int x = 5;

        while (x <= n) {
            n /= x;
            result += n;
            System.out.println(result);
        }


        return result;
    }
}
