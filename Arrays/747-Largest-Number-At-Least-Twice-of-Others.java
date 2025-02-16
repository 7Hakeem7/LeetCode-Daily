class Solution {
    public int dominantIndex(int[] nums) {
        //find the max element in O(N) time
        int n = nums.length;
        int maxi = -1;
        int maxInd = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] > maxi){
                maxi = nums[i];
                maxInd = i;
            }
        }
        //for each num check if maxi > 2 * nums[i];
        for(int i = 0; i < n; i++){
            if(maxi < 2 * nums[i] && i != maxInd){
                return -1;
            }
        }
        return maxInd;
    }
}