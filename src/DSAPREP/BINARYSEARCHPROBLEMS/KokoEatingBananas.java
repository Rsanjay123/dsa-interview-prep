package DSAPREP.BINARYSEARCHPROBLEMS;
import java.util.*;

/**
 * Problem: Koko Eating Bananas
 * 
 * Problem Statement:
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile 
 * of bananas and eats k bananas from that pile. If the pile has less than k bananas, she 
 * eats all of them instead and will not eat any more bananas during this hour.
 * 
 * Koko wants to finish eating all the bananas before the guards come back.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * 
 * Example:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Explanation: With speed 4, Koko takes: 3/4=1, 6/4=2, 7/4=2, 11/4=3 hours = 8 hours total
 * 
 * Approach:
 * Binary search on eating speed k. For each speed, calculate total hours needed.
 * If hours <= h, try slower speed. If hours > h, need faster speed.
 * 
 * Algorithm:
 * 1. Binary search on speed k: low=1, high=max(piles)
 * 2. For each mid speed:
 *    - Calculate total hours needed: sum(ceil(pile/mid))
 *    - If hours <= h: can finish, try slower (high = mid-1)
 *    - If hours > h: can't finish, need faster (low = mid+1)
 * 3. Return low (minimum valid speed)
 * 
 * Key insight:
 * - Ceiling division: (pile + mid - 1) / mid = ceil(pile/mid)
 * - Example: ceil(7/4) = (7+4-1)/4 = 10/4 = 2
 * - We binary search on the answer (speed k)
 * 
 * Example walkthrough:
 * piles = [3,6,7,11], h = 8
 * low=1, high=11
 * mid=6: hours = 1+1+2+2 = 6 <= 8, high=5
 * mid=3: hours = 1+2+3+4 = 10 > 8, low=4
 * mid=4: hours = 1+2+2+3 = 8 <= 8, high=3
 * low=4, high=3: done, return 4 ✓
 * 
 * Time Complexity: O(n * log(max(piles))) - binary search O(log(max)), calculate hours O(n)
 * Space Complexity: O(1) - only using constant extra space
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    /**
     * Finds minimum eating speed to finish all bananas in h hours
     * 
     * @param piles Array of banana pile sizes
     * @param h Hours available
     * @return Minimum eating speed k
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // Find maximum pile size (upper bound for speed)
        for(int pile : piles) {
            high = Math.max(high, pile);
        }
        
        // Binary search on eating speed
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int hours = 0;
            
            // Calculate total hours needed with speed mid
            for(int pile: piles) {
                // Ceiling division: (pile + mid - 1) / mid
                // Example: ceil(7/4) = (7+4-1)/4 = 10/4 = 2
                hours += (pile + mid - 1) / mid;
            }
            
            if(hours <= h) {
                // Can finish in time, try slower speed
                high = mid - 1;
            } else {
                // Can't finish in time, need faster speed
                low = mid + 1;
            }
        }
        
        // low is the minimum valid speed
        return low;
    }
}
