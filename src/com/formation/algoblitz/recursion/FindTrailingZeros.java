package com.formation.algoblitz.recursion;

public class FindTrailingZeros {
    public static void main(String[] args) {
        System.out.println(findNumberOfTrailingZeros(13));
    }

    private static int findNumberOfTrailingZeros(int n) {
        double fact = findFactorial(n);
        int result = 0;

        System.out.println("Fact : " + fact);

        while (fact % 10 == 0) {
            result++;
            fact /= 10;
        }

        return result;
    }

    private static double findFactorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * findFactorial(n - 1);
        }
    }
}
