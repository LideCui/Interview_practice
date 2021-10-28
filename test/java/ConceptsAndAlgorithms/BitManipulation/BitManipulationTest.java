package ConceptsAndAlgorithms.BitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitManipulationTest {

    @Test
    void updateBits() {
        int n = 1024; // 10000000000
        int m = 19; // 10011
        int i = 2;
        int j = 6;
        int result = BitManipulation.updateBits(n,m,i,j);
        assertEquals(1100, result);
    }

    @Test
    void printBinary() {
        assertEquals(".101", BitManipulation.printBinary(0.625));
    }

    @Test
    void longestSequence() {
        assertEquals(3, BitManipulation.longestSequence(5));
        assertEquals(3, BitManipulation.longestSequence(19));
        assertEquals(3, BitManipulation.longestSequence(25));
        assertEquals(32, BitManipulation.longestSequence(-1)); //1111...1
        assertEquals(1, BitManipulation.longestSequence(0));
        assertEquals(5, BitManipulation.longestSequence(621)); // 101101101
    }
}