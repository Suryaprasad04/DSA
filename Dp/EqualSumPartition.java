class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return false;
        }
        return subsetSum(arr,sum/2);
    }
    static boolean subsetSum(int[] arr,int w){
        int n=arr.length;
        boolean[][] t=new boolean[n+1][w+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j-arr[i-1]]||t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}
