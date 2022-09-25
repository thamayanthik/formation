package com.formation.algomarthon.map;

/*

Say that 2 strings "match" if they are non-empty and their first chars are the same.
Loop over and then return the given array of non-empty strings as follows:
if a string matches an earlier string in the array, swap the 2 strings in the array.
When a position in the array has been swapped, it no longer matches anything.

Using a map, this can be solved making just one pass over the array.

["aONE", "aTWO"] ? ["aTWO", "aONE"]

["aONE", "bONE", "cONE", "cTWO", "bTWO", "aTWO", "aTHREE", "aFOUR"]
                         |
                         \/
["aTWO", "bTWO", "cTWO", "cONE", "bONE", "aONE", "aFOUR", "aTHREE"]

["aONE", "bONE", "aTWO", "bTWO", "aTHREE", "aFOUR", "bONE", "bTWO"]
                          |
                         \/
 ["aTWO", "bTWO", "aONE", "bONE", "aFOUR", "aTHREE", "bTWO", "bONE"]

Assume all the strings are only alphanumerics.
===

 */
public class ReplaceMatching {
    public static void main(String[] args) {

    }
}
