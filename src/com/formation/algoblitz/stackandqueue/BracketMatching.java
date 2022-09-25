package com.formation.algoblitz.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BracketMatching {
    public static void main(String[] args) {
        System.out.println("()() : is valid : " + checkBracketsMatches("()()"));
        System.out.println("()()) : is valid : " + checkBracketsMatches("()())"));
        System.out.println("()()( : is valid : " + checkBracketsMatches("()()("));
    }

    private static boolean checkBracketsMatches(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        if (!str.isEmpty()) {
            for (int i = 0 ; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    stack.push('(');
                } else if (c == ')') {
                    // check stack has data
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty();
        }

        return true;
    }
}
