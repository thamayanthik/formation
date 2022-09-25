package com.formation.algoblitz.stringprgm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        System.out.println(findLongestWordInDictionary("abpcplea", List.of("ale","apple","monkey","plea")));
        //System.out.println(findLongestWord("abce", List.of("abe","abc","monkey","plea")));
        //"aewfafwafjlwajflwajflwafj"
        //["apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"]
     //   System.out.println(findLongestWord("aewfafwafjlwajflwajflwafj", List.of("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf")));
    }

    public static String findLongestWordInAnyOrder(String s, List<String> dictionary) {
        String resultStr = "";
        Integer maxLen = Integer.MIN_VALUE;

        Map<Character, Integer> sCount = new HashMap<>();
        for (int i = 0; i < s.length();i++) {
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (String dic : dictionary) {
            if (dic.length() <= s.length()) {
                Map<Character, Integer> dictMap = new HashMap<>();
                for (int i = 0; i < dic.length();i++) {
                    if (sCount.containsKey(dic.charAt(i))) {
                        dictMap.put(dic.charAt(i), dictMap.getOrDefault(dic.charAt(i), 0) + 1);
                    } else {
                        dictMap.clear();
                        break;
                    }
                }

                if (!dictMap.isEmpty()) {
                    boolean match = true;
                    for (Character chars :  dictMap.keySet()) {
                        if (sCount.get(chars) < dictMap.get(chars)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        System.out.println("Dictionary Word : " + dic + ", result : " + resultStr);
                        if (maxLen < dic.length()
                                || (maxLen == dic.length() && dic.compareTo(resultStr) < 0)) {
                            maxLen = dic.length();
                            resultStr = dic;
                        }
                    }
                }
            }
        }

        return resultStr;
    }

    public static String findLongestWordInDictionary(String s, List<String> d) {
        String res = "";

        List<String> dictionary = new ArrayList<>();
        dictionary.addAll(d);

        dictionary.sort((String a, String b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        for (String word : dictionary) {
            if (isSubsequence(s, word)  && res.length() < word.length()) {
                res = word;
            }
        }

        return res;
    }

    private static boolean isSubsequence(String S, String D) {
        int i = 0;
        int j = 0;

        if (S.length() < D.length()) return false;

        while (i < S.length() && j < D.length()) {
            if (S.charAt(i) == D.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == D.length();
    }
}

