class Solution {
    private boolean isPossible(int day , int[] nums , int k , int m){
      int count = 0;
      int noOfBouqs = 0;
      int n = nums.length;
      for (int i = 0 ; i<n ; i++){
        if(nums[i] <= day){
          count++;
          if(count == k){
            noOfBouqs++;
            count = 0;
          }
        }
        else {
          count = 0;
        }
      }
      return noOfBouqs >= m ? true : false ;
    }

    public int minDays(int[] nums, int m, int k) {

        int n = nums.length;
        
        if((long)m*k > n) return -1;
        int ans = -1;

        int mini = Integer.MAX_VALUE , maxi = Integer.MIN_VALUE;
        for (int i = 0 ; i< n; i++){
            mini = Math.min(mini , nums[i]);
            maxi = Math.max(maxi , nums[i]);
        }

        int low = mini , high = maxi;

        while(low <= high){
            int day = (low + high)/2;

            if(isPossible(day , nums , k , m)){
                ans = day;
                high = day -1;
            }
            else{
                low = day + 1;
            }
        }
        return ans;
    }
}