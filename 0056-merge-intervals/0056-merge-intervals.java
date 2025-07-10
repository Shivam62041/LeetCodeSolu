class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0; 
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        int start,end;
        int[] mp = new int[max + 1];  
        for (int i = 0; i < intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            mp[start] = Math.max(end+1, mp[start]); 
        }

        int idx = 0; 
        start = -1; 
        end = -1;  
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (start == -1) start = i;
                end = Math.max(mp[i]-1, end); 
            }
            if (end == i) { 
                intervals[idx++] = new int[] { start, end };
                end = -1;
                start = -1;
            }
        }

        if (start != -1) { 
            intervals[idx++] = new int[] { start, end };
        }
        if (intervals.length == idx) { 
            return intervals;
        }

        int[][] res = new int[idx][];
        for (int i = 0; i < idx; i++) {
            res[i] = intervals[i];
        }

        return res;
    }
}