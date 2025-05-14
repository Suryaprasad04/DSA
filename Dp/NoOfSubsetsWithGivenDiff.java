class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
         int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int x = (sum + d);
        if (x % 2 != 0 || x < 0)    
            return 0; // Invalid if x is odd or negative
            x/=2;
        return countOfSubset(arr,x);
    }
    static int countOfSubset(int[] nums, int target) {
        int n = nums.length;
        int[][] t = new int[n + 1][target + 1];
        

        // Base condition using your style
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = 1;
                } else if (i == 0) {
                    t[i][j] = 0;
                } else if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {//see here it is starting from 0
                if (nums[i - 1] <= j) {
                    t[i][j] = (t[i - 1][j - nums[i - 1]] + t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][target];
    }
}
