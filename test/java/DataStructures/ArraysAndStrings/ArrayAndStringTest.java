package DataStructures.ArraysAndStrings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAndStringTest {

    @Test
    void isAllUnique() {
        String str1 = "abc";
        String str2 = "aab";
        assertEquals(true, ArrayAndString.isAllUnique(str1));
        assertEquals(false, ArrayAndString.isAllUnique(str2));
    }

    @Test
    void isPermutation() {
        String s = "ab c";
        String t = "c ab";
        String t2 = "C AB";
        assertEquals(true, ArrayAndString.isPermutation(s,t));
        assertEquals(false, ArrayAndString.isPermutation(s,t2));
    }

    @Test
    void replaceAllSpace() {
        String s = "ab c";
        String t = "ab%20c";
        assertEquals(t, ArrayAndString.replaceAllSpace(s));
    }

    @Test
    void isPanPermutation() {
        String s = "Tact coa";
        assertEquals(true, ArrayAndString.isPanPermutation(s));
    }

    @Test
    void oneEditAway() {
        assertEquals(false, ArrayAndString.oneEditAway("A", "ABC"));
        assertEquals(true, ArrayAndString.oneEditAway("A","B"));
        assertEquals(true, ArrayAndString.oneEditAway("AB","B"));
        assertEquals(true, ArrayAndString.oneEditAway("A","AB"));
    }

    @Test
    void compressStrings() {
        assertEquals("a1b2c3", ArrayAndString.compressStrings("abbccc"));
        assertEquals("a", ArrayAndString.compressStrings("a"));
        assertEquals("b2", ArrayAndString.compressStrings("bb"));
    }

    @Test
    void rotateMatrix() {
        int[][] test = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        // first
        int[][] resultClockWise = {
                {7,4,1},
                {8,5,2},
                {9,6,3},
        };
        // second
        int[][] resultCounter = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        ArrayAndString.rotateMatrix(test, true);
        for(int i = 0; i < 3; i++){
            assertEquals(true, Arrays.equals(resultClockWise[i], test[i]));
            System.out.println(test[i][0]+" "+test[i][1]+" "+test[i][2]);
        }
        ArrayAndString.rotateMatrix(test, false);
        for(int i = 0; i < 3; i++){
            assertEquals(true, Arrays.equals(resultCounter[i], test[i]));
            System.out.println(test[i][0]+" "+test[i][1]+" "+test[i][2]);
        }
    }
}