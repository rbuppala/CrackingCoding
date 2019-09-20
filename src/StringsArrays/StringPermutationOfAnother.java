package StringsArrays;

import java.util.Arrays;

/*
    Check Permutation

    Given two strings, write a method to decide if one is permutation of the other.
 */
public class StringPermutationOfAnother {

    public static void main(String args[]) {
        System.out.println(permutation("aab", "aba"));
        System.out.println(permutationIdenticalChars("aab", "aba"));
    }

    /*
        Approach - Sort the strings and compare
        Time Complexity - O(nLogn)
     */
    public static boolean permutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        return sort(str1).equals(sort(str1));

    }

    private static String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    /*
        Time Complexity O(n)
     */
    public static boolean permutationIdenticalChars(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] letters = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i)]--;

            if (letters[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
