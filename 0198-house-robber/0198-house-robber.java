class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return loot(0,nums);
    }
    private int loot(int i,int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+loot(i+2,nums);
        int skip=loot(i+1,nums);
        int ans=Math.max(pick,skip);
        dp[i]=ans;
        return ans;
    }
}