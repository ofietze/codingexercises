// Task:
// Return an array of size N of counters
// If a number X in A is € [1, N] increment counter X
// If X == N+1 set all counters to the maximum counter value
// Task Score 100% 
class Solution {
    // Time complexity 
    // max(O(N), O(M))
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int lastMax = 0;
        int localMax = 0;
        
        // O(A.length)
        for (int i = 0; i < A.length; i++) {
            int current = A[i];

            if (current >= 1 && current <= N) {
                counters[current - 1] += 1;

                // keep track of max counter value
                if (counters[current - 1] > localMax) {
                    localMax = counters[current - 1];
                }
            } else if (current == N + 1) {
            // The idea is to reset the counters and only keep track 
            // of the changes from here on. We later add the max again.    
               lastMax += localMax;  // Add to last max to counteract the reset
               if (localMax != 0) counters = new int[N]; // reset array only when necessary
               localMax = 0;         // reset localMax
               
            }
        }
       
       // O(N)
        for (int i = 0; i < N; i++) {
            counters[i] += lastMax;
        }
        return counters;
    }
}
