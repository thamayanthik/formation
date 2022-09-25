package com.formation.algomarthon.recursion;

public class BunnyEars {
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
        return 2 + calculateBunnyEars(--n);
    }
}
