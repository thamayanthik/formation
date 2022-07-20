package com.formation.algoblitz.stringprgm;

import java.util.HashSet;
import java.util.Set;

public class ExchangeVowels {
    public static void main(String[] args) {
      //  System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {
        Set<Character> v = new HashSet<>();
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');

        int low = 0;
        int high = s.length() - 1;
        char[] arr = s.toCharArray();
        while (low < high) {

            String lc = String.valueOf(arr[low]).toLowerCase();
            String gc = String.valueOf(arr[high]).toLowerCase();

            if (!v.contains(lc.charAt(0))) {
                low++;
            }
            if (!v.contains(gc.charAt(0))) {
                high--;
            }

            if (v.contains(lc.charAt(0)) && v.contains(gc.charAt(0))) {
                char tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }

        return new String(arr);
    }
}
