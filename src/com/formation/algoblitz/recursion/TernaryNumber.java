package com.formation.algoblitz.recursion;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TernaryNumber {
    private static Stack stack = new Stack();

    public static void main(String[] args) {

        printAllTernaryNumber(1);

        System.out.println();
        System.out.println("------");

        printAllTernaryNumber(2);

        System.out.println();
        System.out.println("------");

        printAllTernaryNumber(3);

        System.out.println();
        System.out.println("------");
    }

    private static void printAllTernaryNumber(int n) {
        int startIndex = 0;
        if (n > 1) {
            startIndex = 1;
        }
        // This will push 1 digit
        for (int i = startIndex; i < 3; i++) {
            stack.add(i);
            helper(n);
            stack.pop();
        }
    }

    private static void helper(int l) {
        if (stack.size() == l) {
            Iterator itr = stack.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next());
            }
            System.out.println();
            return;
        }

        // Helps to create digits from second digit
        for (int i = 0; i < 3; i++) {
            stack.add(i);
            helper(l);
            stack.pop();
        }


    }
}
