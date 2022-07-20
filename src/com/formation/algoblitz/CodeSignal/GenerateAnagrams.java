package com.formation.algoblitz.CodeSignal;

import java.util.ArrayList;
import java.util.List;

/**
 * TimeComplexity :  O(n*n)
 */

public class GenerateAnagrams {
    public static void main(String[] args) {
        List result = generateAnagrams("abc",  new ArrayList<>(), 0, 3);
        System.out.println(result);
        solution2("ABC", "");
    }

    private static List generateAnagrams(String input, ArrayList output, int si, int len) {

        if (si == len) {
            output.add(input);
        } else {
            for (int i = si;i < len; i++) {
                input = swap(input, si, i);
                generateAnagrams(input, output, si + 1, len);
            }
        }

        return output;
    }

    private static String swap(String str, int si, int ei) {
        char[] c = str.toCharArray();
        char tmp = c[si];
        c[si] = c[ei];
        c[ei] = tmp;
        return String.valueOf(c);
    }

    private static void solution2(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
        } else {
            for (int i = 0; i< s.length();i++) {
                char c = s.charAt(i);
                String leftStr = s.substring(0, i);
                String rightStr = s.substring(i + 1, s.length());
                solution2(leftStr + rightStr, ans + c);
            }
        }
    }
}
