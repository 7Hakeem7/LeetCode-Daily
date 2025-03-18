class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxNice = 1;  

        for (int i = 0; i < n; i++) {
            int bitmask = 0; 
            int nice = 0;  

            for (int j = i; j < n; j++) {
                if ((bitmask & nums[j]) == 0) { 
                   
                    bitmask |= nums[j];  
                    nice++;
                    maxNice = Math.max(maxNice, nice);
                } else {
                    break; 
                }
            }
        }
        return maxNice;
    }
}