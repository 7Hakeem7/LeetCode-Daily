class Solution {
    public int longestSquareStreak(int[] nums) {
        //we multiply the square
        //we check if there exists one , if so we do square of the prevoius square again till there exists a squared val in hashMap;

        int count = 0;
        int maxCount = 0;

        int [] hash = new int [100001];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = nums[i];
        }

        long squareVal = 0;
        for(int i = 0; i < nums.length ; i++){
            squareVal = nums[i];
            while(squareVal < 100000 && hash[(int)squareVal] == squareVal){
                squareVal = squareVal * squareVal;
                count++;
            }
            maxCount = Math.max(maxCount , count);
            count = 0;
        }
        return maxCount > 1? maxCount : -1;
        
    }
}