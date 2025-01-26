class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;
        int currSum = 0;
        int totalSum = 0;
        //take out the whole sum once
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        //second traversal, 
        for(int i = 0; i < nums.length - 1; i++){
        //as you move ++ the nums[i] to currsum and -- the nums[i] from total sum
            currSum += nums[i];
            totalSum -= nums[i];
        //now check if the difference between the currsum - totalsum is even
            if((currSum - totalSum) % 2 == 0){
                count++;
            }
        }
        return count;
        
        
    }
}