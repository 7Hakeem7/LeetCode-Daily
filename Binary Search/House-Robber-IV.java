class Solution {
    public int minCapability(int[] nums, int k) {
        //if i revers engineer on this
        // 2,3,5,9    2  4  5  9    min = 0 
        // 2,7,9,3,1       1 2  4 5 9     min = 
        //like i assume one val, and check if it is a possible max val
        int ans = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            low = Math.min(nums[i], low);
            high = Math.max(nums[i], high);
        }
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(nums, mid, k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean isPossible(int [] nums, int mid , int k){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= mid){
                count++;
                i++;//ignore the adjacent buildings
            }
            if (count >= k) {
                return true;  // We have selected enough houses
            }
        }
        return false;
    }
}