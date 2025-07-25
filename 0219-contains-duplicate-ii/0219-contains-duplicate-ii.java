class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n=nums.length;
        HashSet<Integer> set=new HashSet<Integer>();
        int min=Math.min(k,n);

        for(int i=0;i<min;i++){

            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);
        }

        for(int i=k;i<n;i++){

            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);
            set.remove(nums[i-k]);

        }
        

        return false;
    }
}