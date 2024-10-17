class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0 , currNum = 0 , maxRangeNum = 0;
        while(maxRangeNum < n-1){
            int farthest = 0;
            for(int ind = currNum ; ind <= maxRangeNum ; ind++){
                farthest = Math.max(farthest , nums[ind] + ind);
            }
            currNum = maxRangeNum + 1;
            jumps++;
            maxRangeNum = farthest;
        }
        return jumps;
    }
}