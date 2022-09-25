package com.formation.algomarthon.array;

public class RectangleMatching {
    public static void main(String[] args) {
        //System.out.println(isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
       // System.out.println(isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        //System.out.println(isRectangleOverlap(new int[]{-1, 2, 2, 2}, new int[]{1, 1, 3, 3}));
        //System.out.println(isRectangleOverlap(new int[]{-1, 2, -2, 2}, new int[]{-1, 1, 3, 3}));
        System.out.println(isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0]; // 0
        int ay1 = rec1[1]; // 0
        int ax2 = rec1[2]; // 1
        int ay2 = rec1[3]; // 1

        int bx1 = rec2[0]; // 1
        int by1 = rec2[1]; // 0
        int bx2 = rec2[2]; // 2
        int by2 = rec2[3]; // 1

        if (ax2 <= bx1) {
            return false;
        } else if (ay2 <= by1) {
            return false;
        } else if (ax1 >= bx2) {
            return false;
        } else if (ay1 >= by2) {
            return false;
        }


        return true;
    }
}
