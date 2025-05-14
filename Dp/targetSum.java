class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Check if (target + sum) is valid
        if ((target + sum) % 2 != 0 || target > sum || (target + sum) < 0) {
            return 0;
        }

        int x = (target + sum) / 2;
        return countSubsetsOfGivenSum(nums, x);
    }

    public int countSubsetsOfGivenSum(int[] nums, int sum) {
        int[][] t = new int[nums.length + 1][sum + 1];

        // Initialize DP table
        for (int i = 0; i <= nums.length; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[nums.length][sum];
    }
}
