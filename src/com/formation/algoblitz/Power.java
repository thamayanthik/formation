package com.formation.algoblitz;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        double result = pow(x, Math.abs(n));
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }

    private static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double res = pow(x * x , n / 2);
            if (n % 2 != 0) {
                System.out.println("res : " + res + ", x : " + x + ", n : " + n);
                return res * x;
            } else {
                return res;
            }
        }
    }
}
