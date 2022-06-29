package com.formation.algoblitz.arrays;

import java.util.Arrays;

public class CanPlantFlowers {
    public static void main(String... str) {
        int n = 1;
        canPlantFlowers(new int[]{1, 0, 0, 0, 1}, n);

        n = 2;
        canPlantFlowers(new int[]{1, 0, 0, 0, 1}, n);

        n = 1;
        canPlantFlowers(new int[]{1, 0, 0}, n);

        n = 1;
        canPlantFlowers(new int[]{0, 0, 1}, n);

        n = 1;
        canPlantFlowersSolution2(new int[]{0, 0, 1}, n);
    }

    public static void canPlantFlowers(int[] a, int n) {
        System.out.println("a : " + Arrays.toString(a) + ", n : " + n);
        if (a.length == 0) System.out.println("false");

        for (int i = 0; i < a.length; i++) {
            boolean assignPlanet = false;

            if (i == 0) {
                if (a[i] == 0 && a[i + 1] == 0) {
                    assignPlanet = true;
                }
            } else if (i == a.length - 1) {
                if (a[i] == 0 && a[i - 1] == 0) {
                    assignPlanet = true;
                }
            } else if (a[i - 1] == 0 && a[i + 1] == 0 && a[i] == 0) {
                assignPlanet = true;
            }
            if (assignPlanet) {
                n--;
                a[i] = 1;
            }
        }

        if (n > 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    public static void canPlantFlowersSolution2(int[] a, int n) {

        if (a.length == 0) System.out.println("false");

        // append 0 as first and last element, by creating new array with current array length + 2;
        int[] newArray = new int[a.length + 2];

        System.arraycopy(a, 0, newArray, 1, a.length);

        System.out.println("Array Before Plant : " + Arrays.toString(newArray) + ", Number of Plant to Place : " + n);

        for (int i = 1; i < newArray.length - 2; i++) {
            if (newArray[i - 1] == 0 && newArray[i + 1] == 0 && newArray[i] == 0) {
                n--;
                newArray[i] = 1;
            }

        }

        System.out.println("Array After Plant : " + Arrays.toString(newArray) + ", Plant Left : " + n);

        if (n > 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
