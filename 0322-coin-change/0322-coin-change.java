class Solution {
    static int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        int ans=helper(0,coins,amount);
        return (ans!=Integer.MAX_VALUE) ? ans : -1;
    }
    private static int helper(int i,int[] coins,int amount){
        if(i==coins.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=0) return dp[i][amount];
        int skip=helper(i+1,coins,amount);
        if(amount<coins[i]) return skip;
        int take=helper(i,coins,amount-coins[i]);
        int pick=(take==Integer.MAX_VALUE) ? take:take+1;
        return dp[i][amount]=Math.min(pick,skip);
    }
}


// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int ans=helper(0,coins,amount);
//         return (ans!=Integer.MAX_VALUE) ? ans : -1;
//     }
//     private static int helper(int i,int[] coins,int amount){
//         if(i==coins.length){
//             if(amount==0) return 0;
//             else return Integer.MAX_VALUE;
//         }
//         int skip=helper(i+1,coins,amount);
//         if(amount<coins[i]) return skip;
//         int take=helper(i,coins,amount-coins[i]);
//         int pick=(take==Integer.MAX_VALUE) ? take : take+1;
//         return Math.min(pick,skip); 
//     }
// }