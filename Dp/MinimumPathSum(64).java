class Solution {//recursion
    public int minPathSum(int[][] grid) {
            int m=grid.length,n=grid[0].length;
            return f(m-1,n-1,grid);
    }
    public int f(int i,int j,int[][] grid){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        int up=f(i-1,j,grid);
        int left=f(i,j-1,grid);
        
        // Math.min handles Integer.MAX_VALUE properly
        return grid[i][j] + Math.min(up, left);
    }
    
}


class Solution {
    public int minPathSum(int[][] grid) {//memoization
            int m=grid.length,n=grid[0].length;
            
            int[][] dp=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dp[i][j]=-1;
                }
            }

            return f(m-1,n-1,grid,dp);
    }
    public int f(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }

    if(dp[i][j]!=-1){
        return dp[i][j];
    }
        int up=f(i-1,j,grid,dp);
        int left=f(i,j-1,grid,dp);
        
        // Math.min handles Integer.MAX_VALUE properly
        return dp[i][j]=grid[i][j] + Math.min(up, left);
    }
    
}




class Solution {//tabulation
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }else{
                    int up=(i>0)?dp[i-1][j]:Integer.MAX_VALUE;
                    int left=(j>0)?dp[i][j-1]:Integer.MAX_VALUE;
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
               
            }
        }
        return dp[m-1][n-1];    
    }

    
}




class Solution {//with space optimization
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;

        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){

                if(i==0 && j==0){
                    temp[j]=grid[i][j];
                }else{
                    int up=(i>0)?dp[j]:Integer.MAX_VALUE;
                    int left=(j>0)?temp[j-1]:Integer.MAX_VALUE;
                    temp[j]=grid[i][j]+Math.min(up,left);
                }
               
            }
            dp=temp;
        }
        return dp[n-1];    
    }

    
}
