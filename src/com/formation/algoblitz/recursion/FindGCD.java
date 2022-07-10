package com.formation.algoblitz.recursion;

/**
 * Formal description of the Euclidean algorithm:
     * Input Two positive integers, a and b.
     * Output The greatest common divisor, g, of a and b.
     * Internal computation
         * If a<b, exchange a and b.
         * Divide a by b and get the remainder, r. If r=0, report b as the GCD of a and b.
         * Replace a by b and replace b by r. Return to the previous step.
 */
public class FindGCD {
    public static void main(String[] args) {
       System.out.println("gcd : " + findGcd(10, 12));
    }

    public static int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            if (a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            int r = a % b;
            return findGcd(b, r);
        }
    }
}
