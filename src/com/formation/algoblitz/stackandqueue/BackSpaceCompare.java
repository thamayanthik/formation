package com.formation.algoblitz.stackandqueue;

import java.util.Stack;
import java.util.stream.Collectors;

public class BackSpaceCompare {
    public static void main(String[] args) {
        System.out.println(backSpaceCompare("ab#c", "ad#c"));
        System.out.println(backSpaceCompare("ab##", "c#d#"));
        System.out.println(backSpaceCompare("a#c", "b"));
    }

    private static boolean backSpaceCompare(String fStr, String sStr) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int index = 0;

        while (index < fStr.length() || index < sStr.length()) {
            if (index < fStr.length()) {
                if (fStr.charAt(index) != '#') {
                    s1.push(fStr.charAt(index));
                } else if (!s1.isEmpty()) {
                    s1.pop();
                }
            }

            if (index < sStr.length()) {
                if (sStr.charAt(index) != '#') {
                    s2.push(sStr.charAt(index));
                } else if (!s2.isEmpty()) {
                    s2.pop();
                }
            }
            index++;
        }

        String rStr1 = "";
        if (!s1.isEmpty()) {
            rStr1 = s1.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(""));
        }
        String rStr2 = "";
        if (!s2.isEmpty()) {
            rStr2 = s2.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(""));
        }

        System.out.println("rStr1 : " + rStr1 + ", rStr2 : " + rStr2);

        return rStr1.equals(rStr2);
    }
}
