package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationInPhoneNumber {

    public static void main(String[] args) {

        letterCombinations("234");

    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> numberToChar = new HashMap<>();
        numberToChar.put('1', "");
        numberToChar.put('2', "abc");
        numberToChar.put('3', "def");
        numberToChar.put('4', "ghi");
        numberToChar.put('5', "jkl");
        numberToChar.put('6', "mno");
        numberToChar.put('7', "pqrs");
        numberToChar.put('8', "tuv");
        numberToChar.put('9', "wxyz");

        List<String> letterCombination = new ArrayList<>();
        List<String> list = getListOfCharacterMaps(digits, numberToChar);

        generateSequence(list, 0, digits.length(), "", letterCombination);
        return letterCombination;
    }

    private static void generateSequence(List<String> input, int index, int len, String ans, List<String> result) {
        if (ans.length() == len) {
            System.out.println(ans);
            result.add(ans);
            return;
        }

        String chars = input.get(index);
        for (int i = 0; i < chars.length(); i++) {
            ans += chars.charAt(i); // choose
            generateSequence(input, index + 1, len, ans, result); // if we ans + chars.charAt(i) in the method, below line not required
            ans = ans.substring(0, ans.length() - 1); // un choose
        }
    }

    private static List<String> getListOfCharacterMaps(String digits, Map<Character, String> numberToChar) {

        List<String> numAsString = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            numAsString.add(numberToChar.get(digits.charAt(i)));
        }
        return numAsString;
    }
}
