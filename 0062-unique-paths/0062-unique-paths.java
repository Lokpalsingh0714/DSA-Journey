class Solution {
    static int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        return paths(m,n);
    }
    private static int paths(int m,int n){
        if(m==1 || n==1) return 1;
        if(dp[m][n]!=0) return dp[m][n];
        return dp[m][n] = paths(m-1,n)+paths(m,n-1);
    }
}