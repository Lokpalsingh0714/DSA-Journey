class Solution {
    static int[][] dp;
    public int minDistance(String a, String b) {
        int m=a.length(),n=b.length();
        dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return edit(m-1,n-1,new StringBuilder(a),new StringBuilder(b));
    }
    static int edit(int i,int j,StringBuilder s1,StringBuilder s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return edit(i-1,j-1,s1,s2);
        int replace=1+edit(i-1,j-1,s1,s2);
        int remove=1+edit(i-1,j,s1,s2);
        int insert=1+edit(i,j-1,s1,s2);
        return dp[i][j]=Math.min(replace,Math.min(remove,insert));
    }
}