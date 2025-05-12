class Solution {//recursion
    public int fib(int n) {
          if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
}



class Solution {//recursion with memoization
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fibonacci(n,dp);
    }
    public int fibonacci(int n,int[] dp){
        if(n<=1) return n;

        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=fibonacci(n-1,dp)+fibonacci(n-2,dp);
    }
}



class Solution {//top down
    public int fib(int n) {
     int[] dp=new int[n+1];
        if(n==0)
            return 0;
        if(n==2)
            return 1;
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        
    }
}



class Solution {//top down using extra space
    public int fib(int n) {
     int[] dp=new int[n+1];
        if(n==0)
            return 0;
        if(n==2)
            return 1;
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        
    }
}

