class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid[0].length;
        return f(0,0,m-1,grid);
    }
    public int f(int i,int j1,int j2,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)-1e8;
        }
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int max=Integer.MIN_VALUE;
           // Try all 9 move combinations
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int nextJ1 = j1 + dj1;
                int nextJ2 = j2 + dj2;
                int cherries = (j1 == j2) ? grid[i][j1] : (grid[i]  [j1] + grid[i][j2]);
                cherries += f(i + 1, nextJ1, nextJ2, grid);
                max = Math.max(max, cherries);
            }
        }
        return max;

    }
}






class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int[][] layer:dp)
            for(int[] row:layer)
                Arrays.fill(row,-1);
        return f(0,0,m-1,grid,dp);
    }
    public int f(int i,int j1,int j2,int[][] grid,int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)-1e8;
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                int nextJ1=j1+dj1;
                int nextJ2=j2+dj2;
                int cherries=(j1==j2)?grid[i][j1]:(grid[i][j1]+grid[i][j2]);
                cherries+=f(i+1,nextJ1,nextJ2,grid,dp);
                max=Math.max(max,cherries);
            }
        }
        return dp[i][j1][j2]=max;
    }
}






class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2]=grid[n-1][j1];
                }else{
                    dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
                }
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int max=Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int nj1=j1+dj1;
                            int nj2=j2+dj2;
                            if(nj1>=0 && nj1<m && nj2>=0 && nj2<m){
                                int cherries=(j1==j2)?grid[i][j1]:(grid[i][j1]+grid[i][j2]);
                                cherries+=dp[i+1][nj1][nj2];
                                max=Math.max(max,cherries);
                            }
                        }
                    }
                    dp[i][j1][j2]=max;
                }
            }
        }
        
        return dp[0][0][m-1];
    }
}






class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] front=new int[m][m];
        int[][] cur=new int[m][m];

        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    front[j1][j2]=grid[n-1][j1];
                }else{
                    front[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
                }
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int max=Integer.MIN_VALUE;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int nj1=j1+dj1;
                            int nj2=j2+dj2;
                            if(nj1>=0 && nj1<m && nj2>=0 && nj2<m){
                                int cherries=(j1==j2)?grid[i][j1]:(grid[i][j1]+grid[i][j2]);
                                cherries+=front[nj1][nj2];
                                max=Math.max(max,cherries);
                            }
                        }
                    }
                    cur[j1][j2]=max;
                }
            }
            int[][] temp=front;
            front=cur;
            cur=temp;
        }

        return front[0][m-1];
    }
}
