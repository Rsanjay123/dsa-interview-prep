package DSAPREP;
import java.util.*;

/**
 * Problem: Repeated DNA Sequences
 * 
 * Problem Statement:
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * 
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 * 
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences 
 * (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 * 
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * 
 * Approach:
 * Use HashSet to track seen sequences. If we see a sequence again and haven't added it yet, 
 * add it to result.
 * 
 * Algorithm:
 * 1. Check if string length < 10, return empty list
 * 2. Create two sets: seen (all sequences) and added (sequences already in result)
 * 3. For each 10-character substring:
 *    - If sequence already in seen (seen.add returns false):
 *      * Check if not already added
 *      * If not added, add to result and added set
 *    - Otherwise, add to seen set
 * 4. Return result
 * 
 * Key insight:
 * - seen.add(sub) returns false if sub already exists
 * - added.add(sub) returns true only if sub wasn't in added set
 * - This ensures we add each repeated sequence only once
 * 
 * Example walkthrough:
 * s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * i=0: sub="AAAAACCCCC", seen.add returns true, add to seen
 * i=1: sub="AAAACCCCCA", seen.add returns true, add to seen
 * ...
 * i=10: sub="AAAAACCCCC", seen.add returns false (already seen)
 *       added.add returns true (not in added), add to result
 * i=15: sub="CCCCCAAAAA", seen.add returns false (already seen)
 *       added.add returns true, add to result
 * 
 * Time Complexity: O(n) where n is length of string
 * Space Complexity: O(n) for the sets
 */
public class RepeatedDNASequence {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    /**
     * Finds all 10-letter-long DNA sequences that occur more than once
     * 
     * @param s DNA sequence string
     * @return List of repeated 10-letter sequences
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        
        // Need at least 10 characters for a sequence
        if(s.length() < 10) {
            return result;
        }
        
        // seen: tracks all sequences we've encountered
        Set<String> seen = new HashSet<>();
        // added: tracks sequences already added to result (to avoid duplicates)
        Set<String> added = new HashSet<>();
        
        // Check each 10-character substring
        for(int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            
            // seen.add(sub) returns false if sub already exists
            // If already seen and not already added, add to result
            if(!seen.add(sub) && added.add(sub)) {
                result.add(sub);
            }
        }
        return result;
    }
}
