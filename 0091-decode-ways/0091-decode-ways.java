class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
    public int solve(String s,int ind){
        if(ind>=s.length())return 1;
        if(s.charAt(ind)=='0')return 0;

        if(dp[ind]!=-1)return dp[ind];

        //one digit
        int opt1=solve(s,ind+1);
        //two digit
        int opt2=0;
        if(ind+1<=s.length()-1 && (s.charAt(ind) =='1' ||  s.charAt(ind)=='2' && s.charAt(ind+1)<'7') ){
            opt2=solve(s,ind+2);
        }
        return dp[ind]= opt1+opt2;
    }
}