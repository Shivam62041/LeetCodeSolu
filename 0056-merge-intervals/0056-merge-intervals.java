class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
           return a[0]-b[0];
        });
        ArrayList<int[]> ls=new ArrayList<>();
        int s=intervals[0][0];
        int e=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
              if(e>=intervals[i][0]){
                e= Math.max(e,intervals[i][1]);
              }else{
                ls.add(new int[]{s,e});
                s=intervals[i][0];
                e=intervals[i][1];
              }
        }
        ls.add(new int[]{s,e});
        int[][] ans=new int[ls.size()][2];
        for(int i=0;i<ls.size();i++){
            ans[i][0]=ls.get(i)[0];
            ans[i][1]=ls.get(i)[1];
        }
        return ans;
    }
}