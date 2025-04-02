class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxVal = 0;
        
        for(int i = 0; i < nums.length - 2; i++){
            int f1 = nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                int f2 = nums[j];
                for(int k = j + 1; k < nums.length; k++){
                    // if(i < j && j < k){
                        long currVal = ((long)f1 - (long)f2) * nums[k];
                        maxVal = Math.max(maxVal, currVal);
                    //}
                }
            }
        }
        return maxVal;
    }
}