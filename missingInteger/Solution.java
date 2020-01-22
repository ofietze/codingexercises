// Task: return smallest int > 0 that is not in the given array A
// Task Score 100%
class Solution {
	// Time Complexity: 
	// O(n + n-1) = O(n)
    public int solution(int[] A) {
        int len = A.length;
        boolean[] seen = new boolean[len+1];
        
        // special case for one element
        if (len == 1){
            if (A[0] != 1) return 1;
            else return 2;
        } 
        
        for (int i = 0; i < len; i++) {
            int current = A[i];
            
            if (current > 0 && current <= len) seen[A[i]] = true;
        }
        
        for (int j = 1; j < seen.length; j++) {
            if (seen[j] == false) return j;
        }
        
        return seen.length;
    }
}
