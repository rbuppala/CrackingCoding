package StringsArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Is Unique: Implement an algorithm to determine if string has all unique characters.

 */
public class StringUniqueChars {

    public static void main(String args[]) {
        String s = "aba";
        System.out.println(isUnique(s));
        System.out.println(isUniqueASCII(s));
        System.out.println(isUniqueBruteForce(s));
        System.out.println(isUniqueSorting(s));
        System.out.println(isUniqueChecker(s));
    }

    /*
        Approach - HashSet
        Time Complexity o(n)
     */
    public static boolean isUnique(String str) {
        Set<Character> charSet = new HashSet<>();

        char[] charArray = str.toCharArray();

        for (char ch : charArray) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }

    /*
        Approach- Boolean Array
        If String contains only ASCII characters
         All the array elements are initially set to false.
         As we iterate over the string, set true at the index equal to the int value of the character.
         If at any time, we encounter that the array value is already true, it means the character with that int value is repeated.
     */
    public static boolean isUniqueASCII(String str) {
        if (str.length() > 128) return false;
        boolean[] uniqueChars = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (uniqueChars[val]) {
                return false;
            }
            uniqueChars[val] = true;
        }
        return true;
    }

    /*
        Brute Force Method
        Time Complexity O(n2)
     */
    public static boolean isUniqueBruteForce(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }

        }
        return true;
    }

    /*
        Time Complexity: O(n log n)
     */
    public static boolean isUniqueSorting(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        for (int i = 0; i < str.length(); i++) {
            if (charArray[i] != charArray[i+1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
        Approach --- Bit Vector
        Time Complexity O(n)
        ASCII for lower case --> 97 to 122
        ASCII for upper case --> 65 to 90

        he approach is valid for strings having alphabet as a-z. This approach is little tricky.
        Instead of maintaining a boolean array, we maintain an integer value called checker(32 bits).

        As we iterate over the string, we find the int value of the character with respect to ‘a’
         with the statement int bitAtIndex = str.charAt(i)-‘a’;

        Then the bit at that int value is set to 1 with the statement 1 << bitAtIndex .

        Now, if this bit is already set in the checker, the bit AND operation would make checker > 0.
        Return false in this case.

        Else Update checker to make the bit 1 at that index with the statement checker = checker | (1 <<bitAtIndex);
     */

    public static boolean isUniqueChecker(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {

            int index = str.charAt(i) - 'a'; // The range of index is 0 - 26 , 'a' is 97

            int bitIndex = 1 << index;   // Index of 1 in binary represents the character

            if ((checker & bitIndex) > 0) {
                return false;
            }

            checker = checker | bitIndex;

        }
        return true;
    }


}
