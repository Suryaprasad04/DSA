class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1]; // Array to track trust relationships
        
        // Process each trust pair
        for (int[] t : trust) {
            trustCount[t[0]]--; // Decrease trust for the person who trusts someone
            trustCount[t[1]]++; // Increase trust for the person who is trusted
        }
        
        // Find the town judge
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) { // Judge should be trusted by (N-1) people
                return i;
            }
        }
        
        return -1; // No judge found
    }
}
