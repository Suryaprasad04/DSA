class Solution {//recursive
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // edge case

        int case1 = helper(nums, 0, n - 2); // exclude last
        int case2 = helper(nums, 1, n - 1); // exclude first

        return Math.max(case1, case2);
    }

    private int helper(int[] nums, int start, int end) {
        return robRecursive(nums, end, start);
    }

    private int robRecursive(int[] nums, int index, int base) {
        if (index == base) return nums[base];
        if (index < base) return 0;

        int pick = nums[index] + robRecursive(nums, index - 2, base);
        int nonPick = robRecursive(nums, index - 1, base);

        return Math.max(pick, nonPick);
    }
}






class Solution {//recursion with memoization
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = helper(nums, 0, n - 2, dp1); // exclude last

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = helper(nums, 1, n - 1, dp2); // exclude first

        return Math.max(case1, case2);
    }

    private int helper(int[] nums, int start, int end, int[] dp) {
        if (end == start) return nums[start];
        if (end < start) return 0;

        if (dp[end] != -1) return dp[end];

        int pick = nums[end] + helper(nums, start, end - 2, dp);
        int nonPick = helper(nums, start, end - 1, dp);

        return dp[end] = Math.max(pick, nonPick);
    }
}












class Solution {//tabulation
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int case1 = robRange(nums, 0, n - 2); // exclude last
        int case2 = robRange(nums, 1, n - 1); // exclude first

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n];

        dp[0] = nums[start];
        for (int i = 1; i < n; i++) {
            int pick = nums[start + i];
            if (i > 1) pick += dp[i - 2];
            int nonPick = dp[i - 1];
            dp[i] = Math.max(pick, nonPick);
        }

        return dp[n - 1];
    }
}





class Solution {
    public int rob(int[] nums) {//space optimization
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: Rob from 0 to n-2 (exclude last house)
        int case1 = robRange(nums, 0, n - 2);

        // Case 2: Rob from 1 to n-1 (exclude first house)
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1 = nums[start];
        int prev2 = 0;

        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i];
            if (i > start + 1) {
                pick += prev2;
            }/
            int nonPick = prev1;
            int current = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}


