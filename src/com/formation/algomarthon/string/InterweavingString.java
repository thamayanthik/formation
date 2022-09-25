package com.formation.algomarthon.string;

public class InterweavingString {

    public static void main(String[] args) {
        System.out.println(interweavingStrings("your", "yourstep", "youryourstep"));
        System.out.println(interweavingStrings("algoexpert", "your-dream-job", "your-algodream-expertjob"));
        System.out.println(interweavingStrings("a", "ab", "b"));
        System.out.println(interweavingStrings("a", "b", "ab"));
    }

    public static boolean interweavingStrings(String one, String two, String three) {
        int i = 0, j = 0, k = 0;

        if (three.length() != (one.length() + two.length())) {
            return false;
        }

        while (k < three.length()) {
            char tc = three.charAt(k);
            if (i < one.length() && one.charAt(i) != tc && j < two.length() && two.charAt(j) != tc) {
                return false;
            } else if (one.charAt(i) == tc && two.charAt(j) == tc) {
                int i1 = i;
                int j1 = j;
                while (k < three.length()) {
                    if (one.charAt(i1) == tc && two.charAt(j1) == tc) {
                        i1++;
                        j1++;
                    } else if (one.charAt(i1) == tc) {
                        // reset j
                        i = i1;
                        break;
                    } else if (two.charAt(j1) == tc) {
                        // reset i;
                        j = j1;
                        break;
                    }
                    k++;
                }
            } else if (one.charAt(i) == tc) {
                i++;
            } else if (two.charAt(j) == tc) {
                j++;
            }
            k++;
        }

        return true;
    }
}
