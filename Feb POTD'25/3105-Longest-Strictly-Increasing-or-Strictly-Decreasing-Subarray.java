class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1;
        int decLen = 1;
        int count1 = 1;
        int count2 = 1;
    
        //first traverse to get the longest Increasing curve
        for(int i = 1; i < nums.length; i++){ 
            if(nums[i] > nums[i - 1]){
                count1++;
                count2 = 1;
                incLen = Math.max(incLen , count1);
            }
            else if(nums[i] < nums[i - 1]) {
                count2++;
                count1 = 1;
                decLen = Math.max(decLen , count2);
            }
            else{
                count1 = 1;
                count2 = 1;
            }
        }
        return Math.max(incLen , decLen);
        //return the max of both of them
    }
}