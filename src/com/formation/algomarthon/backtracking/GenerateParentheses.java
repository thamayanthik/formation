package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
You're a coder - you know how important it is to have a closing parenthesis for every opening parenthesis!
Given n pairs of parentheses, write a function that generates all the possible combinations of regular parentheses,
sorted in lexicographical order.

Example

For n = 4, the output should be

solution(n) =
[
  "(((())))", "((()()))",
  "((())())", "((()))()",
  "(()(()))", "(()()())",
  "(()())()", "(())(())",
  "(())()()", "()((()))",
  "()(()())", "()(())()",
  "()()(())", "()()()()"
]
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generateParenthesis(4, "", 0, 0, result);
        System.out.println(result);
    }

    private static List<String> generateParenthesis(int n, String ans, int leftCount, int rightCount,  List<String> res) {
        if (ans.length() == n * 2) {
            res.add(ans);
            return res;
        }

        if (leftCount < n) {
            generateParenthesis(n, ans + "(" , leftCount + 1, rightCount, res);
        }

        if (rightCount < leftCount) {
            generateParenthesis(n, ans + ")" , leftCount, rightCount + 1, res);
        }

        return res;
    }
}
