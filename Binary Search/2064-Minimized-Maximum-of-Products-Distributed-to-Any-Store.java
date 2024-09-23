class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxi = Integer.MIN_VALUE;;
        for(int i = 0 ; i<quantities.length ; i++){
            maxi = Math.max(maxi , quantities[i]);
        }
        int ans = -1;
        int low = 1 , high = maxi;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(mid , quantities , n)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
    private boolean isPossible(int val , int[] quantities , int n){
        int stores = 0;
        for (int i = 0; i<quantities.length ; i++){
            if(quantities[i] % val == 0){
                stores += quantities[i]/val;
            }
            else{
                stores += quantities[i]/val + 1;
            }
            if(stores>n)return false;
        }
        return true;
    }
}