package com.formation.session.pairlearning;

import java.util.ArrayList;
import java.util.List;

public class GenerateKSequence {
    public static void main(String[] args) {
        generateSequence(3,4, new ArrayList<>(), 1);
        generateSequence(2,3, new ArrayList<>(), 1);
        generateSequence(5,5, new ArrayList<>(), 1);
    }

    private static void generateSequence(int len, int n, List<Integer> sequence, int nextSequence) {
        if (sequence.size() == len) {
            System.out.println("Sequence : " + sequence);
            return;
        }
        for (int i = nextSequence; i <=n; i++) {
            sequence.add(i); // choose
            generateSequence(len, n, sequence, i + 1); // Explore
            sequence.remove(sequence.size() - 1); // un choose
         }
    }
}
