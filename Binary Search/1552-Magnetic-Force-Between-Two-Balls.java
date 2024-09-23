class Solution {
    public int maxDistance(int[] nums, int m) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 1 , high = (nums[n-1] - nums[0])/(m-1);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canWePlace(nums , mid , m) == true){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }
    private boolean canWePlace(int[] nums , int dist , int cows){
        int n = nums.length;
        int last = nums[0];
        int cowsCnt = 1;
        for (int i = 1 ; i< n ; i++){
            if(nums[i] - last >= dist){
                cowsCnt++;
                last = nums[i];
            }
        }
        return cowsCnt >= cows ? true : false ;
    }
    
}