package ConceptsAndAlgorithms.BitManipulation;

public class BitManipulation {
    /**
     * clear all bits except the target bit
     */
    boolean getBit(int num, int i) {
        return (num & (1 << i))!= 0;
    }


    /**
     * Set the target bit to 1
     */
    int setBit(int num, int i) {
        return num | (1 << i);
    }

    /**
     * clear the target bit to 0
     */
    int clearBit(int num, int i){
        int mask = ~(1 << i);
        return num & mask;
    }

    /**
     * clear bits from most significant number to i
     */
    int clearBitMSBThroughI(int num, int i){
        int mask = (1 << i) - 1; // leave sequence of 0s followed by i 1s
        return num & mask;
    }

    /**
     * clear bits from i to 0
     */
    int clearBitsIThrough0(int num, int i){
        int mask = ~(-1 >>> (31 - i));
        return num & mask;
    }

    /**
     *
     * update the target bit to given value.
     */
    int updateBit(int num, int i, boolean bitIs1){
        int value = bitIs1? 1: 0;
        int mask = ~(1 <<i);
        return (num & mask) | (value << i);
    }

    /**
     * Given two 32 bit numbers, and two bit position i and j. Write algorithm which insert M into N that
     * M starts at j and ends at i.
     */
    public static int updateBits(int n, int m, int i, int j){
        // positions between i and j are not enough
        if( j-i+1 < (int)(Math.log(m)/Math.log(2))){
            return 0;
        }
        int allOnes = ~0;
        int left = allOnes << (j+1);// 11100000
        int right = ((1 << i) -1); // 00000011
        int mask = left | right;// 11100011
        //System.out.println(Integer.toBinaryString(mask));
        int n_cleared = n & mask;
        int m_shifted = m << i;
        //System.out.println(Integer.toBinaryString(m));
        return n_cleared | m_shifted;
    }

    /**
     * Given a real number between 1 and 0 that is passed in double,
     * print the binary representation. If it cannot be represented within 32 binary char, print ERROR
     */
    public static String printBinary(double num){
        if(num >=1 || num < 0) return "ERROR";

        double frac = 0.5;
        StringBuilder binary = new StringBuilder(".");
        while(num > 0){
            if(binary.length() > 32) return "ERROR";
            if(num >= frac){
                binary.append(1);
                num -= frac;
            }else{
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }

    /**
     * Flip bit to win: you have an integer and you can flip exactly one bit from a 0 to a 1
     * write code to find the longest sequence of 1s you can create
     * step 1. count 3 sequences
     * step 2. record the max length
     */
    public static int longestSequence(int n){
        int searchFor = 0;
        int[] sequences = {0,0,0};
        int maxSequence = 1;
        int SEQUENCE_LENGTH = Integer.toBinaryString(n).length();

        for(int i=0; i < SEQUENCE_LENGTH; i++){
            if((n & 1) != searchFor){
                if(searchFor == 1){
                    maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
                }
                searchFor = 1 & n;
                shift(sequences);
            }
            sequences[0] ++;
            n >>>= 1;
        }

        if(searchFor == 0){
            shift(sequences);
        }
        return Math.max(maxSequence, getMaxSequence(sequences));
    }

    private static void shift(int[] sequences) {
        sequences[2] = sequences[1];
        sequences[1] = sequences[0];
        sequences[0] = 0;
    }

    private static int getMaxSequence(int[] seq){
        if(seq[1] ==1 ){
            return seq[0] + seq[2] + 1;
        }else if (seq[1] == 0){
            return Math.max(seq[0], seq[2]);
        }else{
            return Math.max(seq[0], seq[2]) + 1;
        }
    }
}
