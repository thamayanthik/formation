package com.formation.algoblitz.recursion;

import java.util.Map;

public class AsciitoInteger {
    private static  Map<Character, Integer> map =
            Map.of('1', 1, '2',2,'3',3,'4',4,
                    '5',5,'6',6,'7',7, '8', 8,'9',9,'0',0
            );

    public static void main(String[] args) {
        int value = convertAsciiToInt("-123");
        System.out.println(value);

        value = recursive("-123", 0, 0);
        System.out.println(value);
    }

    private static int convertAsciiToInt(String str) {
        int result = 0;

        char[] ascii = str.toCharArray();

        boolean isNegative = ascii[0] == '-' ? true : false;

        for (int i = 0 ; i < str.length(); i++) {
            if (ascii[i] != '-') {
                result = result * 10 + map.get(ascii[i]);
            }
        }

        if (isNegative) {
            result = -result;
        }

        return result;
    }

    private static int recursive(String val, int index, int result) {
        if (index == val.length()) {
            if ('-' == val.charAt(0)) {
                result = -result;
            }
            return result;
        } else {
            if ('-' != val.charAt(index)) {
                result = result * 10 + map.get(val.charAt(index));
            }

            return recursive(val, ++index, result);

        }
    }
}
