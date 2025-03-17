class Solution {
    public boolean divideArray(int[] nums) {
        //sort the array
        //goal = nums.length / 2
        //if no of pairs == goal return true elese false
        Arrays.sort(nums);
        int goal = nums.length / 2;
        int count = 0;
        //2 2 2 2 3 3
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                count++;
                i++;
            }
            if(count == goal)return true;
        }
        return false;
    }
}