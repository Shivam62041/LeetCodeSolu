class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0,right=matrix[0].length-1;
        int top=0,bottom=matrix.length-1;
        List<Integer> lst = new LinkedList<Integer>();
        while(true){
            for(int i = left; i<=right;i++){
                lst.add(matrix[top][i]);
            }
            top++;
            if(left>right || top>bottom) break;
            for(int i = top; i<=bottom;i++){
                lst.add(matrix[i][right]);
            }
            right--;
            if(left>right || top>bottom) break;
            for(int i = right; i>=left;i--){
                lst.add(matrix[bottom][i]);
            }
            bottom--;
            if(left>right || top>bottom) break;
            for(int i = bottom; i>=top;i--){
                lst.add(matrix[i][left]);
            }
            left++;
            if(left>right || top>bottom) break;

        }
        return lst;
    }
}