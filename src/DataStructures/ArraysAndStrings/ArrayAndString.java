package DataStructures.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class ArrayAndString {

    /**
     * determine if a string has all unique character
     * hint: hash table, vector, O(N log N)
     * <p>
     * cond: ASCII string or Unicode
     * then use an array to test
     * or use bit operation to reduce space complexity by a factor of 8 if 'a' = 'z'
     */
    public static boolean isAllUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int shift = str.charAt(i) - 'a';
            if ((checker & (1 << shift)) == 1) return false;
            checker |= (1 << shift);
        }
        return true;
    }

    /**
     * Given two strings, decide if one is the permutation of the other
     * hint:
     * <p>
     * cond: Case sensitive, white space significant?
     */
    public static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];

        char[] s_char = s.toCharArray();
        for (char c : s_char) {
            letters[c]++;
        }

        char[] t_char = t.toCharArray();
        for (char c : t_char) {
            letters[c]--;
            if (letters[c] < 0) return false;
        }
        return true;
    }

    /**
     * replace all spaces with "%20"
     */
    public static String replaceAllSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    /**
     * Palindrome permutation
     * Given a string, write a function to check if it is a permutation of a palindrome.
     * Input: Tact coa
     *
     * case-insensetive, ignore space
     */
    public static boolean isPanPermutation(String s){
        int countOdd = 0;
        int[] table = new int[26];
        char[] charArray = s.toCharArray();
        for(char c: charArray){
            int val = 0;

            if( 0<= (c-'a') && (c-'a') <= 25){
                val = val -'a';
            }else if(0<= (c-'A') && (c-'A') <= 25){
                val = val - 'A';
            }else {
                val = -1;
            }

            if(val > -1){
                table[val]++;
                if(table[val] %2 == 0){
                    countOdd--;
                }else{
                    countOdd++;
                }
            }
        }
        return countOdd <= 1;
    }

    /**
     * There are 3 types of edits that can be performed on strings: insert a character, remove a character, or replace
     * a character. write a function to check if they are one edit away
     *
     * replacement: if two strings have the same length,
     * insertion/delete: two strings are only one step away
     */
    public static boolean oneEditAway(String first, String second){
        if(Math.abs(first.length() - second.length()) > 1){
            return false;
        }

        String s1 = first.length() > second.length()? first: second;
        String s2 = first.length() > second.length()? second: first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(foundDifference) {
                    return false;
                }
                foundDifference=true;
                if(s1.length() > s2.length()){
                    index1++;
                }else {
                    index1++;
                    index2++;
                }
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters. For example,
     * the string aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the original
     * string, your method should return the original string.
     */
    public static String compressStrings(String s) {
        StringBuilder sb = new StringBuilder();
        int countConsecutive = 0;
        for(int i =0; i < s.length(); i++){
            countConsecutive++;
            if(i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
                sb.append(s.charAt(i));
                sb.append(countConsecutive);
                countConsecutive=0;
            }
        }

        return sb.toString().length() > s.length()? s: sb.toString();
    }

    /**
     * Given an image represent by an NxN matrix, where each pixel in the image is 4 bytes, write a method to
     * rotate the image by 90 degree. Implement both counter clockwise(1) and clockwise(0)
     * the best we can do is O(n^2), for it must touch every elements
     */
    public static int[][] rotateMatrix(int[][] matrix,boolean isClockWise){
        int n = matrix.length;
        if(isClockWise){
            // we rotate to matrix from out circle to in circle
            for(int layer=0; layer < n/2; layer++){
                int first = layer;
                int last = n-1-layer;
                for(int i=first; i < last; i++){
                    int offset = i - first;
                    // save top
                    int top = matrix[first][i];
                    // left -> top
                    matrix[first][i] = matrix[last - offset][first];
                    // bottom -> left
                    matrix[last - offset][first] = matrix[last][last - offset];
                    // right -> bottom
                    matrix[last][last-offset] = matrix[i][last];
                    // top -> right
                    matrix[i][last] = top;
                }
            }
        }else{
            // we rotate to matrix from out circle to in circle
            for(int layer=0; layer < n/2; layer++){
                int first = layer;
                int last = n-1-layer;
                for(int i=first; i < last; i++){
                    int offset = i - first;
                    // save top
                    int top = matrix[first][i];
                    // right -> top
                    matrix[first][i] = matrix[i][last];
                    // bottom -> right
                    matrix[i][last] = matrix[last][last - offset];
                    // left -> bottom
                    matrix[last][last-offset] = matrix[last-offset][first];
                    // top -> left
                    matrix[last-offset][first] = top;
                }
            }
        }
        return matrix;
    }

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
     */
    public static void setZeros(int[][] matrix){
        boolean hasRowZero = false;
        boolean hasColZero = false;

        for(int i=0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0) {
                hasRowZero = true;
                break;
            }
        }

        for(int i=0; i < matrix.length; i++){
            if(matrix[i][0] == 0) {
                hasColZero = true;
                break;
            }
        }

        for(int i=1; i < matrix.length; i++){
            for(int j=1; j < matrix[i].length ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // TODO nullify rows
        // TODO nullify columns
    }

    /**
     * String rotation: assume you have method isSubString(s1, s2), write code to check where s2 is a rotation of s1
     * using only one call to is Substring.
     */
    public static int isRotation(String s1, String s2){
        int len = s1.length();
        if(len == s2.length() && len > 0){
            String s1s1 = s1 + s1;
            return len - s1s1.indexOf(s2);
        }
        return -1;
    }

    private static boolean isSubString(String s1, String s2){
        if(s1.length() < s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        return s1.indexOf(s2) >= 0;
    }
}
