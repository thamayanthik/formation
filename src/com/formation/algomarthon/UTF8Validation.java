package com.formation.algomarthon;

public class UTF8Validation {
    public static void main(String[] args) {
        System.out.println(validateUTF8Encoding(new int[]{197, 130, 1}));
    }

    private static boolean validateUTF8Encoding(int[] arr) {
        int numberOfBytes = 0;
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                String binaryStr = Integer.toBinaryString(arr[i]);
                System.out.println("BinaryStr : " + binaryStr + ", num : " + arr[i]);
                binaryStr = binaryStr.length() >= 8 ?
                        binaryStr.substring(binaryStr.length() - 8)
                        : "00000000".substring(binaryStr.length() % 8) + binaryStr;;
                if (numberOfBytes == 0) {
                    for (int k = 0; k < binaryStr.length(); k++) {
                        if (binaryStr.charAt(k) == '0') {
                            break;
                        }

                        numberOfBytes++;
                    }

                    if (numberOfBytes == 0) {
                        continue;
                    }

                    if (numberOfBytes > 4 || numberOfBytes == 1) {
                        System.out.println("Not matching1 :" + arr[i] + ", numberOfBytes : " + numberOfBytes);
                        return false;
                    }
                } else {
                    if (!(binaryStr.charAt(0) != 1 && binaryStr.charAt(1) != 0)) {
                        System.out.println("Not matching :" + arr[i]);
                        return false;
                    }
                }

                numberOfBytes--;
            }
        }

        System.out.println("numberOfBytes "  + numberOfBytes);
        return numberOfBytes == 0;
    }
}
