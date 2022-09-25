package com.formation.algomarthon.recursion;

public class AtoI {
    public static void main(String[] args) {
        System.out.println(convertToInt("12", 0, 0));
        System.out.println(convertToInt("-12", 0, 0));
    }

    private static int convertToInt(String number, int index, Integer res) {
        if (index >= number.length()) {
            if (number.charAt(0) == '-') {
                return -res;
            } else {
                return res;
            }
        }

        res *= 10;
        if ((number.charAt(index) != '-')) {
            Integer val = Integer.parseInt(String.valueOf(number.charAt(index)));
            res += val;
        }

        return convertToInt(number, ++index, res);
    }
}
