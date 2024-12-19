class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi , arr[i]);
            if(maxi < i + 1){
                count++;
            }
        }
        return count;
    }
}