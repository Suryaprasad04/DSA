class Solution {//recursion
    public int uniquePaths(int m, int n) {
        return f(m-1,n-1);
    }
    public int f(int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        int up=f(i-1,j);
        int left=f(i,j-1);
        return up+left;
    }
}



class Solution {//recursion with memoization
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(m-1,n-1,dp);
    }
    public int f(int i,int j,int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=f(i-1,j,dp);
        int left=f(i,j-1,dp);
        return dp[i][j]=up+left;
    }
}



class Solution {//tabulation
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
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
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];

        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=1;
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
