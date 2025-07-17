class Solution {
    Set<String> set;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>();
        for(String x:wordDict){
            set.add(x);
        }
        dp=new Boolean[s.length()];
        return solve(s,0);
    }
    public boolean solve(String s,int ind){
        //base case
        if(ind>=s.length())return true;
        if(dp[ind]!=null)return dp[ind];
        for(int i=ind;i<s.length();i++){
             String sub=s.substring(ind,i+1);
             if(set.contains(sub)){
                if(solve(s,i+1)){
                    return dp[ind]=true;
                }
             }
        }
        return dp[ind]=false;
    }
}