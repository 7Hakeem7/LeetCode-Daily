class Solution {
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        // int zeroCount = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i] * 2;
                nums[i+1] = 0;
                // zeroCount++;
            }
        }
        // System.out.println(nums);
        //0  1  2  3  4  5
        //1 , 4, 0, 1, 0, 4
        int currIndex = 0;
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] != 0){
                ans[currIndex] = nums[i];
                currIndex++;
            }
        }
        return ans;
    }
}