class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        dp=new int[n][m];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,s1,s2);
    }
    public int solve(int i,int j,String s1,String s2){
          //base 
          if(i>=s1.length() || j>=s2.length())return 0;

          if(dp[i][j]!=-1)return dp[i][j];
          //if char is common then pick both char
          if(s1.charAt(i)==s2.charAt(j)){
               return dp[i][j]= 1+solve(i+1,j+1,s1,s2);
          }else{
               // take S1 char
               int opt1=solve(i,j+1,s1,s2);
               // take s2 char
               int opt2=solve(i+1,j,s1,s2);
               return dp[i][j]= Math.max(opt1,opt2);
          }
    }
}