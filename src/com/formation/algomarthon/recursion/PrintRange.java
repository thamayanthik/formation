package com.formation.algomarthon.recursion;

/**
 * Write a recursive function named printRange that accepts integer parameters x and y
 * and prints the sequential integers between x and y inclusive in a particular format.
 * <p>
 * The first half should be printed with the greater-than character (">") separating consecutive values.
 * The second half should be printed with the less-than character ("<") separating consecutive values.
 * When there are two values in the middle of the range,
 * those two values should be separated by a pair of dashes ("--"), as shown in the second example output below.
 * <p>
 * The following table shows several calls and their expected output:
 * <p>
 * Call	Output
 * printRange(1, 9);	1 > 2 > 3 > 4 > 5 < 6 < 7 < 8 < 9
 * printRange(1, 10);	1 > 2 > 3 > 4 > 5 -- 6 < 7 < 8 < 9 < 10
 * printRange(23, 29);	23 > 24 > 25 > 26 < 27 < 28 < 29
 * printRange(13, 14);	13 -- 14
 * printRange(-8, -8);	-8
 */
public class PrintRange {
    public static void main(String[] args) {
        printRange(1, 9);
        System.out.println();
        System.out.println("---------------------");
        printRange(1, 10);
        System.out.println();
        System.out.println("---------------------");
        printRange(23, 29);
        System.out.println();
        System.out.println("---------------------");
        printRange(13, 14);
    }

    private static void printRange(int low, int high) {
        int mid = (low + high) / 2;
        boolean evenCount = high % 2 != 0 ? false : true;
        System.out.println("mid : " + mid + ", eventCount : " + evenCount);
        print(low, high, mid, evenCount);
    }

    private static void print(int low, int high, int mid, boolean evenCount) {
        if (low > high) {
            return;
        }

        System.out.print(low);

        if (low + 1 <= high) {
            if (low < mid) {
                System.out.print(">");
            } else if (low == mid && evenCount) {
                System.out.print("--");
            } else {
                System.out.print("<");
            }
        }
        print(++low, high, mid, evenCount);
    }
}
