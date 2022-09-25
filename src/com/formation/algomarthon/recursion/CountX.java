package com.formation.algomarthon.recursion;

public class CountX {

    public static void main(String[] args) {
        System.out.println(countX("xxhixx", 0, 0));
        System.out.println(countX("xhixhix", 0, 0));
        System.out.println(countX("XXXhXXX", 0, 0));
        System.out.println(countX("hiAAhi12hi", 0, 0));

    }

    private static int countX(String str, int sum, int index) {
        if (index >= str.length()) {
            return sum;
        }

        if (str.charAt(index) == 'x') {
            sum += 1;
        }

        return countX(str, sum, ++index);
    }
}
