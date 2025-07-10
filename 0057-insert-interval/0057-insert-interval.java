class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int result[][] = new int[intervals.length+1][2];  
        int i=0, j=0;

        // PART 1:: Adding left part to the result
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            // intervals[i][1] --> Current End Time 
            // newInternval[0] --> New interval Start Time
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
            i++; j++;
        }

        // PART 2::Handling the Overlapping Part
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            // intervals[i][0] --> Current Start Time 
            // newInternval[1] --> New interval End Time
            newInterval[0]=Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        //adding it to the result
        result[j][0] = newInterval[0];
        result[j][1] = newInterval[1];
        j++;

        // PART 3:: Adding Right part to the result
        while(i<intervals.length){
            result[j][0] = intervals[i][0];
            result[j][1] = intervals[i][1];
            i++; j++;
        }


        return Arrays.copyOfRange(result, 0, j);
    }
}