package com.formation.algoblitz;

import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {
    public static void main(String[] args) {
        System.out.println(generatePassword(new char[] {'a'}, new ArrayList<>(), "", 2, 4));
        System.out.println(generatePassword(new char[] {'a', 'b'}, new ArrayList<>(), "", 2, 4));
    }

    private static List<String> generatePassword(char[] chars, List<String> result, String password, int minLen, int maxLen) {
        if (password.length() >= minLen && password.length() <= maxLen) {
            result.add(password);
        }

        if (password.length() == maxLen) return result;

        for (int i = 0; i < chars.length; i++) {
            //password += chars[i];
            generatePassword(chars, result, password + chars[i], minLen, maxLen);
          //  password = password.substring(0, password.length() - 1);
        }

        return result;
    }
}
