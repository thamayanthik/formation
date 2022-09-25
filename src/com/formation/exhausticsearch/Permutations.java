package com.formation.exhausticsearch;

import java.util.HashSet;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        permutations("AAB");
        permutations("AAABBC");
    }

    private static void permutations(String str) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            String fp = String.valueOf(str.charAt(i));
            String sp = str.substring(i + 1) + str.substring(0, i);
            result.addAll(generatePermutation(fp, sp, new HashSet<>()));
        }

        System.out.println("Str : " + str + ",  Result : " + result + ", Size : " + result.size());
    }

    private static Set<String> generatePermutation(String fp, String remaining, Set<String> result) {
        result.add(fp);

        if (remaining.isEmpty()) {
            return result;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String fp1 = String.valueOf(remaining.charAt(i));
            String sp = remaining.substring(i + 1);
            generatePermutation(fp + fp1, sp, result);
        }

        return result;
    }

}
