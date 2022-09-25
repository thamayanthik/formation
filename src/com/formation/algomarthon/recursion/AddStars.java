package com.formation.algomarthon.recursion;

public class AddStars {
    public static void main(String[] args) {
        printStars("hello", 0);
    }

    private static void printStars(String str, int index) {
        if (index >= str.length()) {
            return;
        }

        System.out.print(str.charAt(index));
        if (index + 1 < str.length()) {
            System.out.print("*");
        }

        printStars(str, ++index);
    }
}
