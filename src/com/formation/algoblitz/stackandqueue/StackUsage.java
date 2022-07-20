package com.formation.algoblitz.stackandqueue;

import java.util.Stack;

public class StackUsage {
    public static void main(String[] args) {
        System.out.println(findNestedIfCount(new String[] {"if", "else", "if", "endif", "endif"}));
        System.out.println(findNestedIfCount(new String[]{"if", "if", "endif"}));
    }


    private static int findNestedIfCount(String[] nestedIf) {
        Stack<String> s = new Stack();
        int count = 0;
        for (int i = 0; i < nestedIf.length; i++) {
            if (nestedIf[i].equals("if")) {
                s.push(nestedIf[i]);
                count = Math.max(count, Long.valueOf(s.stream().count()).intValue());
            } else if (nestedIf[i].equals("endif")) {
                s.pop();
            } else if (nestedIf[i].equals("else") || nestedIf[i].equals("elseif")) {
                String topValue = s.pop();
                if (topValue.equals("if") || topValue.equals("elseif")) {
                    s.push(nestedIf[i]);
                } else {
                    return -1;
                }
            }
        }

        System.out.println("count : " + count + ", is stack Empty : " +  s.isEmpty());

        if (!s.isEmpty()) {
           return -1;
        }

        return count;
    }
}
