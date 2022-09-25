package com.formation.algoblitz.stringprgm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramStrings {

    public static void main(String[] args) {
        System.out.println("abc : " + findAnagrams("cbaebabacd", "abc"));
        System.out.println("ab : " + findAnagrams("abab", "ab"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int index = 0;
        List<Integer> res = new ArrayList<>();
        int currentCharSeqCount = 0;
        Map<Character, Integer> scount = new HashMap<>();
        int trackIndex = 0;

        Map<Character, Integer> pcount = new HashMap<>();
        for(int k = 0; k < p.length(); k++) {
            pcount.put(p.charAt(k), pcount.getOrDefault(p.charAt(k), 0)  +1);
        }

        while (index < s.length()) {
            // once tmp length = target length, check whether the substring anagram of p
            currentCharSeqCount++;
            scount.put(s.charAt(index), scount.getOrDefault(s.charAt(index), 0)  +1);
            if (currentCharSeqCount == p.length()) {
                if (pcount.equals(scount)) {
                    res.add((index + 1) - p.length());
                }
                currentCharSeqCount--;
                int currentCount = scount.get(s.charAt(trackIndex));
                if (currentCount == 1) {
                    scount.remove(s.charAt(trackIndex));
                } else {
                    scount.put(s.charAt(trackIndex), --currentCount);
                }
                trackIndex++;
            }

            index++;
        }

        return res;
    }
}
