class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return ways(n);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int ways(int n){
        //base 
        if(n==0)return 1;
        if(n<0) return 0;
        if(dp[n]!=-1)return dp[n];

        return dp[n]=ways(n-1)+ways(n-2);
    }
}