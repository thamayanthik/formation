package com.formation.algoblitz.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllSubSequences {
    public static void main(String[] args) {

       // System.out.println(findAllSubSequences("abc", "", new ArrayList<>()));

        System.out.println(solution2("abc", new ArrayList<>(), ""));
    }

    private static List findAllSubSequences(String word, String ans, ArrayList result) {
        if (ans.length() > 0 && !result.contains(ans)) {
            result.add(ans);
        }

        if (word.length() > 0) {
            findAllSubSequences(word.substring(1), ans + word.charAt(0), result);
            findAllSubSequences(word.substring(1), ans, result);
        }

        return result;
    }

    private static List solution2(String str, List result, String ans) {
        if (ans.length() > 0) {
            result.add(ans);
        }

        if (str.length() > 0) {
            for (int i = 0; i < str.length();  i++) {
                char ch = str.charAt(i);
                solution2(str.substring(i+1), result, ans + ch);
            }
        }

        return result;
    }
}
