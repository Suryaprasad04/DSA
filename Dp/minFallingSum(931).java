class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int minSum=Integer.MAX_VALUE;
        for(int j=0;j<n;j++) {
            minSum=Math.min(minSum, f(matrix, 0, j));
        }
        return minSum;
    }
    public int f(int[][] arr,int i,int j){
        if(j<0 || j>=arr[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==arr.length-1){
            return arr[i][j];
        }
        
        int down=f(arr,i+1,j);
        int leftDiag=f(arr,i+1,j-1);
        int rightDiag=f(arr,i+1,j+1);

        return arr[i][j]+Math.min(down,Math.min(leftDiag,rightDiag));
    }
}



class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int minSum=Integer.MAX_VALUE;

        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        for(int j=0;j<n;j++) {
            minSum=Math.min(minSum, f(matrix, 0, j,dp));
        }

        return minSum;
    }
    public int f(int[][] arr,int i,int j,int[][] dp){
        if(j<0 || j>=arr[0].length){
            return Integer.MAX_VALUE;
        }
        if(i==arr.length-1){
            return dp[i][j]=arr[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int down=f(arr,i+1,j,dp);
        int leftDiag=f(arr,i+1,j-1,dp);
        int rightDiag=f(arr,i+1,j+1,dp);

        return dp[i][j]=arr[i][j]+Math.min(down,Math.min(leftDiag,rightDiag));
    }
}




class Solution {
    public int minFallingPathSum(int[][] matrix) {// little confusing
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base case: fill the last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Bottom-up DP
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = dp[i + 1][j];
                int leftDiag = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = j < n - 1 ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        // Minimum in the top row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];

        // Initialize the last row
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[n - 1][j];
        }

        // Bottom-up computation
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int down = prev[j];
                int leftDiag = j > 0 ? prev[j - 1] : Integer.MAX_VALUE;
                int rightDiag = j < n - 1 ? prev[j + 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
            }
            prev = curr;
        }

        // Minimum in the first row (which is now stored in prev)
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, prev[j]);
        }

        return minSum;
    }
}
