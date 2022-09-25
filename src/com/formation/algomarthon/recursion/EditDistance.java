package com.formation.algomarthon.recursion;

/*
rite a recursive function named editDistance that accepts string parameters s1 and s2 and
returns the "edit distance" between the two strings as an integer.
Edit distance (also called Levenshtein distance) is defined as the minimum number of "changes" required to get
from s1 to s2 or vice versa.
A "change" can be defined as a) inserting a character, b) deleting a character, or c)
changing a character to a different character.

Call	Value Returned
editDistance("driving", "diving")	1
editDistance("debate", "irate")	3
editDistance("football", "cookies")	6
Constraints: Your solution must obey the following constraints:

Your solution must not use any loops; it must be recursive.
Strings have member functions named find and refind, but you should not call them,
because they allow you to get around using recursion. Similarly,
the replace member is forbidden. You should limit yourself to using only the following string members:
at, append, compare, erase, insert, length or size, substr, trim, operators such as [], ==, !=, <, etc.
Do not construct any data structures (no array, vector, set, map, etc.), and
do not declare any global variables. You are allowed to define other "helper" functions if you like.
. . .

C++ solution code goes here
Function: Write a C++ function as described, not a complete program.
You must log in before you can solve this problem.

Log In

 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(countCharDiff("driving", 0,"diving", 0, 0));
        System.out.println(countCharDiff("debate", 0,"irate", 0, 0));
        System.out.println(countCharDiff("football", 0,"cookies", 0, 0));
    }

    private static int countCharDiff(String s1, int i, String s2, int j, int mismatchCount) {
        if (i >= s1.length() || j >= s2.length()) {
            return mismatchCount;
        }

        if (s1.charAt(i) != s2.charAt(j)) {
            i++;
            mismatchCount += 1;
        } else {
            i++;
            j++;
        }

        return countCharDiff(s1, i, s2, j, mismatchCount);
    }

}
