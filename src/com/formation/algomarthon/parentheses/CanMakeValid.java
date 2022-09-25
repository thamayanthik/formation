package com.formation.algomarthon.parentheses;

import java.util.*;

/**
 * LeetCode : 2116. Check if a Parentheses String Can Be Valid
 * A parentheses string is a non-empty string consisting only of '(' and ')'.
 * It is valid if any of the following conditions is true:
 * <p>
 * It is ().
 * It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
 * It can be written as (A), where A is a valid parentheses string.
 * You are given a parentheses string s and a string locked, both of length n.
 * locked is a binary string consisting only of '0's and '1's. For each index i of locked,
 * <p>
 * If locked[i] is '1', you cannot change s[i].
 * But if locked[i] is '0', you can change s[i] to either '(' or ')'.
 * Return true if you can make s a valid parentheses string. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "))()))", locked = "010100"
 * Output: true
 * Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
 * We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.
 * Example 2:
 * <p>
 * Input: s = "()()", locked = "0000"
 * Output: true
 * Explanation: We do not need to make any changes because s is already valid.
 * Example 3:
 * <p>
 * Input: s = ")", locked = "0"
 * Output: false
 * Explanation: locked permits us to change s[0].
 * Changing s[0] to either '(' or ')' will not make s valid.
 */
public class CanMakeValid {
    public static void main(String[] args) {
        System.out.println("canBeValid : [Expected : True] : Result : " + canBeValid("))()))", "010100"));
        System.out.println("Approach3 :  [Expected : True] : Result : " + approach3("))()))", "010100"));
        System.out.println("Approach3 :  [Expected : True] : Result : " + approach3("()()", "0000"));
        System.out.println("Approach3 :  [Expected : False] : Result : " + approach3(")", "0"));
        System.out.println("Approach3 :  [Expected : True] : Result : " + approach3("((", "00"));
        //"((()(()()))()((()()))))()((()(()"
        //"10111100100101001110100010001001"
        System.out.println("canBeValid : [Expected : True] : Result : " + canBeValid("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001"));
        System.out.println("Approach3 : [Expected : True] : Result : " + approach3("((()(()()))()((()()))))()((()(()", "10111100100101001110100010001001"));
        /*
        "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))("
        "100011110110011011010111100111011101111110000101001101001111"
         */
        System.out.println("canBeValid : [Expected : False] : Result : " + canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));
        System.out.println("Approach3 : [Expected : False] : Result : " + approach3("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));

        /*
        "()() ( ( ( ) ) ) ( ("
"1       1 1 1 1 1 1 0 1 1 0 1 "
         */
        System.out.println("Approach3 : [Expected : False] : Result : " + approach3("()()((()))((", "111111101101"));
        /*
            "())()))()(()(((())(()()))))((((()())(())"
            "1011101100010001001011000000110010100101"
         */

        System.out.println("Approach3 : [Expected : True] : Result : " + approach3("())()))()(()(((())(()()))))((((()())(())", "1011101100010001001011000000110010100101")); // Expected: true
    }

    public static boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 0) {
            // check whether original string valid or not, if valid no need to do anything
            boolean valid = isValid(s);
            if (!valid) {
                // check opening bracket
                int changeAllowed = 0, openingBracket = 0, closingBracket = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (locked.charAt(i) == '0') {
                        changeAllowed++;
                    } else if (s.charAt(i) == '(') {
                        openingBracket++;
                    } else {
                        closingBracket++;
                    }
                    //   System.out.println("s[" + i + "]= " + s.charAt(i) + ", changeAllowed : " + changeAllowed + ", openingBracket : " + openingBracket + ", closingBracket : " + closingBracket);
                    if (closingBracket > changeAllowed + openingBracket) {
                        return false;
                    }
                }
                // check opening bracket
                changeAllowed = 0;
                openingBracket = 0;
                closingBracket = 0;
                for (int i = s.length() - 1; i > 0; i--) {
                    if (locked.charAt(i) == '0') {
                        changeAllowed++;
                    } else if (s.charAt(i) == '(') {
                        openingBracket++;
                    } else {
                        closingBracket++;
                    }

                    if (openingBracket > changeAllowed + closingBracket) {
                        return false;
                    }
                }

                return true;
            } else {
                return true;
            }
        }

        return false;
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    private static boolean approach2(String s, String locked) {
        if (s.length() % 2 == 0) {
            if (isValid(s)) {
                return true;
            } else {
                int left = 0, right = 0, change = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        if (right > 0) {
                            right--;
                        } else {
                            left++;
                        }
                    } else if (s.charAt(i) == ')') {
                        if (left > 0) {
                            left--;
                        } else {
                            right++;
                        }
                    }
                    if (locked.charAt(i) == '0') {
                        change++;
                    }
                }

                System.out.println("change : " + change + ", left : " + left + ", right : " + right);
                if (change >= (left + right)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    private static boolean approach3(String s, String locked) {
        if (s.length() % 2 == 0) {
            if (isValid(s)) {
                return true;
            } else {
                int len = s.length() - 1;
                if ((s.charAt(0) == ')' || s.charAt(len) == '(') && locked.charAt(len) == '1') {
                    return false;
                }

                int lockedLeft = 0;
                List<Integer> unLockedIndexSoFar = new ArrayList<>();
                char[] lockedCharArr = locked.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ')' && lockedCharArr[i] == '1') {
                        // Either unlocked index should exist before i or locked ( should exist
                        if (lockedLeft > 0) {
                            lockedLeft--;
                        } else if (!unLockedIndexSoFar.isEmpty()) {
                            unLockedIndexSoFar.remove(unLockedIndexSoFar.size() - 1);
                        } else {
                            return false;
                        }
                    } else if (s.charAt(i) == '(' && lockedCharArr[i] == '1') {
                        lockedLeft++;
                    } else {
                        unLockedIndexSoFar.add(i);
                    }
                }

                //System.out.println("After, lockedLeft : " + lockedLeft + ", unLockedIndexSoFar size : " + unLockedIndexSoFar.size());
                //Hint3: After the above, we may have locked indices of '(' and additional unlocked indices.
                //       How can you balance out the locked '(' now? What if you cannot balance any locked '('?
                if ((lockedLeft == 0 && unLockedIndexSoFar.size() % 2 == 0)
                     || (lockedLeft > 0 && unLockedIndexSoFar.size() >  lockedLeft)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }
}
