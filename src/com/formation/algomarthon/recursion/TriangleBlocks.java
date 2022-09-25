package com.formation.algomarthon.recursion;

public class TriangleBlocks {
    public static void main(String[] args) {
        System.out.println(calculateTriangleBlock(2));
        System.out.println(calculateTriangleBlock(3));
        System.out.println(calculateTriangleBlock(5));
        System.out.println(calculateTriangleBlock(12));

    }

    private static int calculateTriangleBlock(int n) {
        if (n == 1) {
            return 1;
        }

        return n + calculateTriangleBlock(n-1);
    }
}
