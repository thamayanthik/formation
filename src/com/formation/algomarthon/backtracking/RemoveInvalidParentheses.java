package com.formation.algomarthon.backtracking;

import org.apache.commons.lang3.time.StopWatch;

import java.util.*;

public class RemoveInvalidParentheses {
    private static HashSet<String> visited = new HashSet<>();

    public static void main(String[] args) {
        String str = "((()((s((((()";

        approach1(str);
    }

    private static void approach1(String str) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // remove invalid parentheses if exists in start or end, in the start ) is considered as invalid and in the end ( is considered as invalid
        if (str.charAt(0) == ')' || str.charAt(str.length() - 1) == '(') {
            str = removeInvalidStartAndEnd(str);
        }
        //result : [()s(), ()(s), (()s)], Execution Time : 3742


        int inValidCount = getInvalidParenthesesCount(str);
        List<String> result = new ArrayList<>();
        removeInvalidParentheses(str, inValidCount, result);

        stopWatch.stop();
        System.out.println("result : " + result + ", Execution Time : " + stopWatch.getTime());
    }


    private static String removeInvalidStartAndEnd(String str) {
        int low = 0;
        int high = str.length() - 1;
        int startValidIndex = 0;
        int endValidIndex = str.length() - 1;
        boolean fixedStart = false, fixedEnd = false;
        while (low < high) {
            if (fixedEnd && fixedStart) {
                break;
            }
            if (!fixedStart) {
                if (str.charAt(low) == ')') {
                    startValidIndex++;
                    low++;
                } else {
                    fixedStart = true;
                }
            }
            if (!fixedEnd) {
                if (str.charAt(high) == '(') {
                    endValidIndex--;
                    high--;
                } else {
                    fixedEnd = true;
                }
            }

        }
        str = str.substring(startValidIndex, endValidIndex + 1);
        return str;
    }

    private static void removeInvalidParentheses(String str, int invalidParenthesesCount, List<String> answers) {

        if (invalidParenthesesCount < 0) {
            return;
        }

        if (invalidParenthesesCount == 0) {
            if (getInvalidParenthesesCount(str) == 0 && !answers.contains(str)) {
                answers.add(str);
            } else {
                return;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            String leftOfi = str.substring(0, i);
            String rightOfi = str.substring(i + 1);
            if (!visited.contains(leftOfi + rightOfi)) {
                visited.add(leftOfi + rightOfi);
                removeInvalidParentheses(leftOfi + rightOfi, invalidParenthesesCount - 1, answers);
            }
        }

    }

    private static int getInvalidParenthesesCount(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                stack.push(str.charAt(i));
            }
        }

        return stack.size();
    }
}
