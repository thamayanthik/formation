package com.formation.algomarthon.recursion;

public class BunnyEarsTwist {
    public static void main(String[] args) {
        System.out.println(calculateBunnyEars(2));
        System.out.println(calculateBunnyEars(3));
        System.out.println(calculateBunnyEars(5));
        System.out.println(calculateBunnyEars(12));

    }

    private static int calculateBunnyEars(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return 3 + calculateBunnyEars(--n);
        } else {
            return 2 + calculateBunnyEars(--n);
        }
    }
}
