// Task: 
// - Given a DNA sequence (length N) represented as a sequence of nucleotides A,C,G and T (values 1,2,3,4)
// - Two Arrays P and Q with the start/end indeces of the queries (M elements)
// Return an array with the minimum value of each section P[x] to Q[x]
// Task Score: 75%; Correctness 100%, Performance 33%
// Failing tests: "almost all same letters" and "large random" (time outs)
// Time complexity: Worst Case: O(M*N) Best Case: O(M)
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] minima = new int[P.length];
        
        // P and Q are guaranteed to have the same length
        // Element P[x] <= Q[x]
        int[][] seenMinima = new int[S.length()][2]; // Safe which part of the String was covered already
        // format: at index i: (minimum, distance looked ahead)
        
        for (int i = 0; i < P.length; i++) {
            // Check if we cover more of the string than last time
           
            minima[i] = findMinimumWithHistory(S.toCharArray(), seenMinima, P[i], Q[i]); 
                
            seenMinima[P[i]][0] = minima[i];
            seenMinima[P[i]][1] = Q[i] - P[i];
        }
        return minima;
    }
    
    // Bounds are guranteed to be correct for String length, s only consists of letters A,C,G,T
    private int findMinimumWithHistory(char[] c, int[][] seenMinima, int lowerBound, int higherBound) {
        int minimum = Integer.MAX_VALUE;
        
        for (int i = lowerBound; i <= higherBound; i++) {
            int currentVal = charToValue(c[i]);
                    
            // Case this part of the String was already searched through, then jump ahead
            if (seenMinima[i][0] != 0) {
                currentVal = seenMinima[i][0];
                i += seenMinima[i][1];
            }
            
            if (currentVal < minimum) {
                minimum = currentVal;
            }
        }
        return minimum;
    }
    
    private int charToValue(char c) {
        int currentVal = Integer.MAX_VALUE;
        switch (c) {
                case 'A': currentVal = 1; break;
                case 'C': currentVal = 2; break;
                case 'G': currentVal = 3; break;
                case 'T': currentVal = 4; break;
                default: currentVal = Integer.MAX_VALUE;
            }   
        return currentVal;    
    }
    
}
