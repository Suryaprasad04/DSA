public class Solution {// recursion
    public static int ninjaTraining(int n, int[][] points) {
        return f(n - 1, 3, points); // 3 means no task was done on the previous day
    }

    public static int f(int day, int last, int[][] points) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }
}




public class Solution {//recursion with memoization
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        // Initialize dp array with -1 to indicate uncomputed states
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        return f(n - 1, 3, points, dp); // 3 represents "no task done previously"
    }

    public static int f(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[0][task]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }
}





public class Solution {//tabulation
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        // Base case for day 0
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        maxi = Math.max(maxi, point);
                    }
                }
                dp[day][last] = maxi;
            }
        }

        return dp[n - 1][3]; // max points on the last day with no task restriction
    }
}


public class Solution {//tabulation with 1d array(optimized)
    public static int ninjaTraining(int n, int[][] points) {
        int[] prev = new int[4];

        // Base case for day 0
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        maxi = Math.max(maxi, point);
                    }
                }
                temp[last] = maxi;
            }
            prev = temp; // Move temp to prev for next day
        }

        return prev[3]; // max points on the last day with no task restriction
    }
}

