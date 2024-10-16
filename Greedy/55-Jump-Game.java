class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int newGoal = n - 1;
        for(int i = n - 2; i >= 0 ; i--){
            if(nums[i] + i >= newGoal){
                newGoal = i;
            }
        }
        return newGoal == 0? true : false;
        
    }
}