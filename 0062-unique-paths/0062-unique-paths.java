class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,m,n);
    }
    public int solve(int row,int col,int m,int n){
        //base case
        if(row==m-1 && col==n-1)return 1;
        if(row>m-1 || col>n-1)return 0;

        if(dp[row][col]!=-1)return dp[row][col];

        //right
        int opt1=solve(row,col+1,m,n);
        //down
        int opt2=solve(row+1,col,m,n);
        return dp[row][col]=opt1+opt2;
    }
}