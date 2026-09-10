class Solution {
    static int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,target,nums);
    }
    static int helper(int i,int target,int[] nums){
        if(i==nums.length){
            if(target==0) return 1;
            else return 0;
        }
        int add=helper(i+1,target-nums[i],nums);
        int subt=helper(i+1,target+nums[i],nums);
        return add+subt;
    }
}