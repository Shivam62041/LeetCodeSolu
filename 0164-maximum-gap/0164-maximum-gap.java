class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        int max=0;
        int tempmax=0;
        for(int i=1;i<nums.length;i++){
            int next=nums[i];
            int curr=nums[i-1];
            tempmax=next-curr;
            if(max<tempmax) {
                max=tempmax;
                tempmax=0;
            }
        }
         if(max<tempmax) {
                max=tempmax;
                tempmax=0;
            }
        return max;
    }
}