class Solution {
    public int waysToSplitArray(int[] nums) {
        long [] prefixSum = new long[nums.length];
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }

        //from left to right - 1 element split one by one index
        //check the left part sum >= right part sum
        //if so then count++
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(prefixSum[i] >= prefixSum[nums.length - 1] - prefixSum[i]){
                count++;
            }
        }
        return count;
    }
}