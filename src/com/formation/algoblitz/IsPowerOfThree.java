package com.formation.algoblitz;

public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println("5 powerOfThree " + isPowerOfThree(5));
        System.out.println("-3 powerOfThree " + isPowerOfThree(-3));
        System.out.println("0 powerOfThree " + isPowerOfThree(0));
        System.out.println("27 powerOfThree " + isPowerOfThree(27));
        System.out.println("9 powerOfThree " + isPowerOfThree(9));
        System.out.println("47 powerOfThree " + isPowerOfThree(47));

        System.out.println("47 usingBaseOperation " + usingBaseOperation(47));
    }

    private static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }

    private static boolean usingBaseOperation(int n) {
        String baseChange = Integer.toString(n, 3);

        System.out.println(baseChange);

        boolean powerOfThree = baseChange.matches("^10*$");

        System.out.println("\nEquivalent Integer object is " + Integer.parseInt(baseChange, 3));

        return powerOfThree;
    }
}
