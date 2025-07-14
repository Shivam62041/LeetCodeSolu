class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,n-1);
    }
    public int solve(int[] nums,int i){
        //base case
        if(i<0)return 0;

        if(dp[i]!=-1)return dp[i];

        //take
        int opt1= nums[i] + solve(nums,i-2);
        //skip
        int opt2=solve(nums,i-1);
        return dp[i]= Math.max(opt1,opt2);
    }
}