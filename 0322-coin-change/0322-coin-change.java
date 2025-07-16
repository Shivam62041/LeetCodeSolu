class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n+1][amount+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= solve(0,amount,coins);
        return ans==10000000?-1:ans;
    }
    public int solve(int ind,int amt,int[] coins){
        //base
        if(ind>=coins.length){
            return 10000000;
        }
        if(amt==0)return 0;
        if(dp[ind][amt]!=-1)return dp[ind][amt];
        //pick
        int opt1=10000000;
        if(amt>=coins[ind]){
            opt1=1+ solve(ind,amt-coins[ind],coins);
        }
        //skip
        int opt2=solve(ind+1,amt,coins);
        return  dp[ind][amt]=Math.min(opt1,opt2);
    }
}