class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int n=coins.length;
        int w=sum;
        int[][] t=new int[n+1][w+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                 if(i==0){
                    t[i][j]=0;
                }
                else if(j==0){
                    t[i][j]=1;
                }else if(coins[i-1]<=j){
                    t[i][j]=(t[i][j-coins[i-1]])+t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
                
            }
        }
        return t[n][w];
    }
}
