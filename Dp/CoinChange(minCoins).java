class Solution {
    public int minCoins(int coins[], int sum) {
        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[i][j] = 0;  // 0 coins needed to make sum 0
                } else if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1; // impossible with 0 coins
                }
            }
        }

        // Fill table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum] == Integer.MAX_VALUE - 1 ? -1 : t[n][sum];
    }
}
