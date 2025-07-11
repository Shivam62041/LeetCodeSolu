class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, ( a,b)->{
           return a[1]-b[1];
        });
        int count=0;
        int e=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
              if(intervals[i][0]>=e){
                e=intervals[i][1];
              }else{
                count++;
              }
        }
        return count;
    }
}