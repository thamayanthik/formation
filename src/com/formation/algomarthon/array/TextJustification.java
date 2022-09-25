package com.formation.algomarthon.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        // System.out.println(fullJustifyAlternate(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
       // System.out.println(fullJustifyAlternate(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(fullJustifyAlternate(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        //System.out.println(fullJustifyAlternate(new String[]{"Listen", "to", "many,", "speak", "to", "a", "few."}, 6));
    }

    /*
     * It is not working when length of first word is = to width and also if the word has ,
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> sb = new ArrayList<>();

        int wordCount = 0;
        for (String word : words) {
            String res = getString(sb.toString()).trim();
            if (res.length() + word.length() + 1 > maxWidth) {
                int currentTextLen = res.length();
                if (currentTextLen < maxWidth) {
                    int spaceRequired = maxWidth - currentTextLen + (wordCount - 1);
                    int remainder = 0;
                    if (spaceRequired > 0 && wordCount - 1 > 1) {
                        remainder = spaceRequired % (wordCount - 1);
                        spaceRequired /= (wordCount - 1);

                    }
                    String[] newStr = res.split(" ");
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < newStr.length; i++) {
                        str.append(newStr[i]);
                        if (str.length() < maxWidth) {
                            if (spaceRequired > 0) {
                                str.append(" ".repeat(spaceRequired));
                            }

                            if (remainder > 0) {
                                str.append(" ".repeat(1));
                                remainder--;
                            }
                        }
                    }
                    res = str.toString();
                }

                result.add(res);
                sb = new ArrayList<>();
                wordCount = 0;
            }

            wordCount++;
            sb.add(word);
        }

        if (!sb.isEmpty()) {
            String res = getString(sb.toString());
            if (res.length() < maxWidth) {
                res = res + " ".repeat(maxWidth - res.length());
            }
            result.add(res);
        }

        return result;
    }

    private static String getString(String value) {
        String res = value.trim().replaceAll(",", "");
        res = res.substring(1, res.length() - 1);
        return res;
    }

    public static List<String> fullJustifyAlternate(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        int currentRunningCount = 0;
        int wordCount = 0;
        for (String word : words) {
            if (currentRunningCount == 0 || currentRunningCount + word.length() <= maxWidth) {
                currentRunningCount += word.length() + 1; // 1 is for space
            } else {
                result.add(addSpace(maxWidth, deque, currentRunningCount, wordCount, false));

                currentRunningCount = word.length() + 1;
                wordCount = 0;
            }

            wordCount++;
            deque.add(word);
        }

        if (!deque.isEmpty()) {
            result.add(addSpace(maxWidth, deque, currentRunningCount, wordCount, true));
        }

        return result;
    }

    private static String addSpace(int maxWidth, Deque<String> deque, int currentRunningCount, int wordCount, boolean end) {
        currentRunningCount -= wordCount; // At this point currentRunningCount holds only number of characters
        int totalSpaceRequired = maxWidth - currentRunningCount;
        int equalSpaceCount = 0;
        int extraLeftSpaceCount = 0;
        if (!end && totalSpaceRequired > 0 && wordCount > 1) {
            extraLeftSpaceCount = totalSpaceRequired % (wordCount - 1);
            equalSpaceCount = totalSpaceRequired / (wordCount - 1);
        } else if (wordCount == 1) {
            equalSpaceCount = totalSpaceRequired;
        }

        System.out.println("totalSpaceRequired : " + totalSpaceRequired +", equalSpaceCount " + equalSpaceCount + ", extraLeftSpaceCount : " + extraLeftSpaceCount);

        StringBuilder str = new StringBuilder();
        while (!deque.isEmpty()) {
            str.append(deque.poll());
            if (!end) {
                if (str.length() < maxWidth) {
                    if (equalSpaceCount > 0) {
                        str.append(" ".repeat(equalSpaceCount));
                    }

                    if (extraLeftSpaceCount > 0) {
                        str.append(" ".repeat(1));
                        extraLeftSpaceCount--;
                    }
                }
            } else if (!deque.isEmpty()) {
                totalSpaceRequired--;
                str.append(" ".repeat(1));
            }
        }

        if (end) {
            str.append(" ".repeat(totalSpaceRequired));
        }

        System.out.println(str + ", length : " + str.length());

        return str.toString();
    }
}
