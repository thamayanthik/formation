package com.formation.algomarthon.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game24 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 8, 7};
        System.out.println(isGameOver(convertToList(arr)));
        int[] arr1 = {1, 1, 2, 1};
        System.out.println(isGameOver(convertToList(arr1)));
    }

    private static List<Double> convertToList(int[] arr) {
        List<Double> values = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            values.add((double) arr[i]);
        }

        return values;
    }

    private static boolean isGameOver(List<Double> values) {
        if (values.size() == 1) {
            return Math.abs(values.get(0) - 24) <= 0.1;
        }

        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                List<Double> newValues = new ArrayList<>();
                for (int k = 0; k < values.size(); k++) {
                    if (k != i && k != j) {
                        newValues.add(values.get(k));
                    }
                }

                List<Double> possibleResults = generatePossibleResults(values.get(i), values.get(j));
                for (Double possibleResult : possibleResults) {
                    newValues.add(possibleResult);
                    if (isGameOver(newValues)) {
                        return true;
                    }
                    newValues.remove(newValues.size() - 1);
                }
            }
        }

        return false;
    }

    private static List<Double> generatePossibleResults(double a, double b) {
        List<Double> possibleAns = new ArrayList<>();
        possibleAns.add(a + b);
        possibleAns.add(a - b);
        possibleAns.add(b - a);
        possibleAns.add(a * b);
        if (a != 0) {
            possibleAns.add(b / a);
        }

        if (b != 0) {
            possibleAns.add(a / b);
        }

        return possibleAns;
    }
}
