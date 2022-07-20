package com.formation.algoblitz.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class FreshFlapJacks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFreshFlapJacks(new int[]{2, -1})));
        System.out.println(Arrays.toString(findFreshFlapJacks(new int[]{2, -1, 3, -3, 2, -1})));
        System.out.println(Arrays.toString(findFreshFlapJacks(new int[]{-1, 2})));
    }

    private static Object[] findFreshFlapJacks(int[] fj) {
        Stack s = new Stack();
        boolean served = true;
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < fj.length; i++) {
            int ac = 0;
            if (!s.isEmpty()) {
                ac = (int) s.pop();
            }
            if (fj[i] < 0 && served) {
                if (ac > Math.abs(fj[i])) {
                    ac += fj[i];
                } else {
                    served = false;
                }
            } else if (fj[i] > 0) {
                ac += fj[i];
                maxSize = Math.max(maxSize, ac);
            }

            s.push(ac);
        }

        return new Object[]{served, maxSize};
    }
}
