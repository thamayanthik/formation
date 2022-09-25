package com.formation.session.pairlearning;

/**
 * Given an integer maxLen, print all binary strings of size maxLen that don't have 1s next to each other.
 * That is, no string should contain the substring 11, 111, 1111, 11111, etc. You can assume maxLen > 0.
 * Function Signature:
 * def printBinaryWithoutConsecutive1s(maxLen: int) -> None:
 * Target runtime and space complexity:
 * Time: O(2^n) where n is the length of the binary string.
 * There are n indexes and each index can be either 0 or 1 with some small exceptions
 * Space: O(n) because the stack can reach n recursive frames before being torn down
 */
public class PrintBinary {

    public static void main(String[] args) {
        printBinary("", 2);
        System.out.println("PrintBinary Of Length : 3");
        printBinary("", 3);
        System.out.println("PrintBinary Of Length : 4");
        printBinary("", 4);
    }

    private static void printBinary(String res, int n) {
        if (res.length() == n) {
            System.out.println(res);
            return;
        }

        printBinary(res + "0", n);

        if (res.isEmpty() || res.charAt(res.length() - 1) != '1') {
            printBinary(res + "1", n);
        }
    }
}
