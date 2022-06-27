package com.formation.algoblitz.arrays;

public class ArrayIteration {
    public static void main(String... str) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Print the Array : ");
        printArray(array);
        System.out.println();
        System.out.print("Even Indices : ");
        printValuesAtEvenIndices(array);
        System.out.println();
        System.out.print("Odd Indices : ");
        printValuesAtOddIndices(array);
        System.out.println();
        System.out.print("Print Kth Index value : ");
        printEveryKth(array, 3);
        System.out.println();
        System.out.print("Reverse the Array : ");
        printReverse(array);
        System.out.println();
        System.out.print("Reverse Even Indices : ");
        printValuesAtReverseEvenIndices(array);
        System.out.println();
        System.out.print("Reverse Odd Indices : ");
        printValuesAtReverseOddIndices(array);
        System.out.println();
        System.out.print("Reverse Print Kth Index value : ");
        printValuesAtReverseEveryKth(array, 3);
        System.out.println();
    }

    private static void printArray(int[] a) {
        int i = 0;
        while (i < a.length) {
            System.out.print(a[i] + " ");
            i++;
        }
    }

    public static void printValuesAtEvenIndices(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (i % 2 == 0) {
                System.out.print(a[i] + " ");
            }
            i++;
        }
    }

    public static void printValuesAtOddIndices(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (i % 2 != 0) {
                System.out.print(a[i] + " ");
            }
            i++;
        }
    }

    public static void printEveryKth(int[] a, int k) {
        int i = 0;
        while (i < a.length) {
            System.out.print(a[i] + " ");
            i += k;
        }
    }

    private static void printReverse(int[] a) {
        int i = a.length - 1;
        while (i >= 0) {
            System.out.print(a[i] + " ");
            i--;
        }
    }

    private static void printValuesAtReverseEvenIndices(int[] a) {
        int i = a.length - 1;
        ;
        while (i >= 0) {
            if (i % 2 == 0) {
                System.out.print(a[i] + " ");
            }
            i--;
        }
    }

    private static void printValuesAtReverseOddIndices(int[] a) {
        int i = a.length - 1;
        ;
        while (i >= 0) {
            if (i % 2 != 0) {
                System.out.print(a[i] + " ");
            }
            i--;
        }
    }

    private static void printValuesAtReverseEveryKth(int[] a, int k) {
        int i = a.length - 1;
        while (i >= 0) {
            System.out.print(a[i] + " ");
            i -= k;
        }
    }
}
