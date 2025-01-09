class Solution {
    public int splitArray(int[] a, int k) {
        int sum = 0;
        int low = 0 , high = 0;
        for(int i = 0; i < a.length; i++){
            low = Math.max(low , a[i]);
            sum += a[i];
        }
        high = sum;

        //Binary search based on "maxSum? or not?"
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPartitionable(mid, a, k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean isPartitionable(int maxSum, int[] a, int k){
        int partitions = 1;
        long curSum = 0;
        for(int i = 0; i < a.length; i++){
            if(curSum + a[i] > maxSum){
                partitions++;
                curSum = a[i];
            }
            else{
                curSum += a[i];
            }
            if(partitions > k){
                return false;
            }
        }
        return true;
    }
    
}
