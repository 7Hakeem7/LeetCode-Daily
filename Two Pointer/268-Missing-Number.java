class Solution {
    public int missingNumber(int[] nums) {
        int currSum = 0;
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
        }
        int n = nums.length;
        totalSum = n*(n + 1);
        totalSum = totalSum/2;
        return totalSum - currSum;
    }
}