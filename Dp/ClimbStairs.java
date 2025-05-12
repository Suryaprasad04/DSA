class Solution {//recursion
    public int climbStairs(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}


class Solution {//normal recursion with dp
    public int climbStairs(int n) {

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n,dp);
    } 
    public int climb(int n,int[] dp){
        if(n==0) return 1;
        if(n==1) return 1;

        if(dp[n]!=-1) return dp[n];
        int left=climbStairs(n-1);
        int right=climbStairs(n-2);
        return dp[n]=left+right;
    }
}



class Solution {//Tabulation
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int[] arr=new int[n];
        arr[0]=1;
        arr[1]=2;
        for(int i=2;i<n;i++)
            arr[i]=arr[i-1]+arr[i-2];
        return arr[n-1];
    }
}




class Solution {//space optimization
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int a=1,b=2;
        for(int i=3;i<=n;i++){
            int temp=b;
            b=a+b;
            a=temp;
        }
        return b;
    }
}




















