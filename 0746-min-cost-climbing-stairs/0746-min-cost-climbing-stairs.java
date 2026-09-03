class Solution {
    static int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(stairs(0,cost),stairs(1,cost));
    }
    private int stairs(int i,int[] cost){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=cost[i]+Math.min(stairs(i+1,cost),stairs(i+2,cost));
    }
}