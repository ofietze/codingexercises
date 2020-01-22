// Score 77%, 100% Correctness, 60% Perfomance
// Return an array of size N of counters
// If a number X in A is € [1, N] increment counter X
// If X == N+1 set all counters to the maximum counter value
class Solution {
    
    // Time complexity depends on number of calls to maxCounter
    // o(N), O(N^N)
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];
        int max = 0;
        
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            
            if (current >= 1 && current <= N) {
                counters[current - 1] += 1;
                
                // keep track of max counter value
                if (counters[current - 1] > max) {
                    max = counters[current - 1];
                }
            } else if (current == N + 1) {
               counters = maxCounter(max, counters);
            }
        }
        return counters;
    }
    
    // Set all values in arr to max
    // Time complexity O(arr.length)
    private int[] maxCounter(int max, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = max;
        }
        return arr;
    }
}
