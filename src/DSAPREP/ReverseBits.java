package DSAPREP;
import java.util.*;

/**
 * Problem: Reverse Bits
 * 
 * Problem Statement:
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Example:
 * Input: n = 43261596 (binary: 00000010100101000001111010011100)
 * Output: 964176192 (binary: 00111001011110000010100101000000)
 * 
 * Approach:
 * Convert to binary string, reverse it, then convert back to integer.
 * 
 * Algorithm:
 * 1. Convert integer to binary string
 * 2. Pad to 32 bits with leading zeros
 * 3. Reverse the binary string
 * 4. Parse reversed binary string back to integer
 * 
 * Note: This approach uses string manipulation. A more efficient approach 
 * would use bit manipulation directly.
 * 
 * Example walkthrough:
 * n = 43261596
 * Binary: "10100101000001111010011100"
 * Padded: "00000010100101000001111010011100" (32 bits)
 * Reversed: "00111001011110000010100101000000"
 * Parsed: 964176192 ✓
 * 
 * Time Complexity: O(1) - fixed 32 bits
 * Space Complexity: O(1) - fixed size strings
 */
public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    /**
     * Reverses the bits of a 32-bit unsigned integer
     * 
     * @param n Integer whose bits to reverse
     * @return Integer with reversed bits
     */
    public static int reverseBits(int n) {
        // Convert to binary string
        String binary = Integer.toBinaryString(n);
        
        // Pad to 32 bits with leading zeros
        // Format as 32-character string, replace spaces with zeros
        binary = String.format("%32s", binary).replace(' ', '0');
        
        // Reverse the binary string
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        
        // Parse reversed binary string back to integer
        // Use Long.parseLong to handle unsigned 32-bit values
        return (int) Long.parseLong(String.valueOf(sb), 2);
    }
}
