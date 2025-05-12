// Recursion
class Solution {
    public int rob(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    private int helper(int[] nums, int index) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;

        int pick = nums[index] + helper(nums, index - 2);
        int nonPick = helper(nums, index - 1);

        return Math.max(pick, nonPick);
    }
}




//Recursion with memoization
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums, nums.length - 1,dp);
    }

    private int helper(int[] nums, int index,int[] dp) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;

        if(dp[index]!=-1){
            return dp[index];
        }
        int pick = nums[index] + helper(nums, index - 2,dp);
        int nonPick = helper(nums, index - 1,dp);

        return dp[index]=Math.max(pick, nonPick);
    }
}




//Tabulation
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1){//for non negative indexes
                pick+=dp[i-2];
            }
            int non_pick=0+dp[i-1];
            dp[i]=Math.max(pick,non_pick);
        }
        return dp[nums.length-1];
   
    }
}




//tabulation with space optimization
class Solution {
    public int rob(int[] nums) {
        int prev1=nums[0];
        int prev2=0;
    
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1){//for non negative indexes
                pick+=prev2;
            }
            int non_pick=0+prev1;
            int current=Math.max(pick,non_pick);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
   
    }
}
