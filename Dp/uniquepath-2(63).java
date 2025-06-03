class Solution {//recursion
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        return f(m-1,n-1,obstacleGrid);
    }
    public int f(int i,int j,int[][] mat){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(i>=0 && j>=0 && mat[i][j]==1){// just added this to unique path-1
            return 0;
        }
        int up=f(i-1,j,mat);
        int left=f(i,j-1,mat);
        return up+left;
    
    }
}



class Solution {// with memoization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        if(obstacleGrid[0][0]==1) return 0;
        return f(m-1,n-1,dp,obstacleGrid);
    }
    public int f(int i,int j,int[][] dp,int[][] mat){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i>=0 && j>=0 && mat[i][j]==1){
            return 0;
        }
        int up=f(i-1,j,dp,mat);
        int left=f(i,j-1,dp,mat);
        return dp[i][j]=up+left;
    }
}




class Solution {//tabulation
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    int up=(i>0)?dp[i-1][j]:0;
                    int left=(j>0)?dp[i][j-1]:0;
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];

    }
}



class Solution {//space optimized
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int[] dp=new int[n];

        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }else if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
                    temp[j]=0;
                }else{
                    int up=(i>0)?dp[j]:0;
                    int left=(j>0)?temp[j-1]:0;
                    temp[j]=up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];

    }
}
