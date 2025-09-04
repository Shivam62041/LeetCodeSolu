class Solution {
    public int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = getMax(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = getMax(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
