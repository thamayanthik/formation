package com.formation.algoblitz.linkedlist;

public class CountOddValues {
    public static void main(String[] args) {
        int oddCount = countOddValues(NodeCreationHelper.createNode(8));

        System.out.println("Result : " + oddCount);

        oddCount = countOddValuesUsingRecursion(NodeCreationHelper.createNode(8));

        System.out.println("CountOddValuesUsingRecursion Result : " + oddCount);
    }

    private static int countOddValues(Node node) {
        int count = 0;
        while (node != null) {
            if (node.value % 2 != 0) {
                count++;
            }
            node = node.next;
        }

        return count;
    }

    private static int countOddValuesUsingRecursion(Node node) {
        if (node == null) {
            return 0;
        } else {
            if (node.value % 2 != 0) {
                return 1 + countOddValuesUsingRecursion(node.next);
            } else {
                return countOddValuesUsingRecursion(node.next);
            }
        }
    }
}
