class Solution {
    public int maximumCount(int[] nums) {
        //-3,-2,-1,0,0,1,2, 3, 4, 5, 6, 7
        //-5,-4,-3,-2,-1 0 0 1 2 3 4
        //0 0 0 0 0 0
        if(nums.length == 1 && nums[0] < 0)return 1;
        //binary search
        //i'll only need to find indexOf lower bound which is just < 0
        int negIndex = lowerBound(nums);
        System.out.println(negIndex);
        // and need to find indexOf upper Bound which is just > 0
        int posIndex = upperBound(nums);
        System.out.println(posIndex);
        //using indices for pos = nums.length - upper Bound Index
        int posCount = nums.length - posIndex;
        int negCount = 0;
        if(negIndex != 0)negCount = negIndex + 1;
        //for neg = 0 + lower Bound index + 1;
        //return Math.max(pos, neg);
        return Math.max(posCount, negCount);
    }
    private int lowerBound(int[] nums){
        int lowerIndex = 0;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] < 0){
                lowerIndex = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return lowerIndex;
    }
    private int upperBound(int[] nums){
        int upperIndex = nums.length;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] > 0){
                upperIndex = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return upperIndex;
    }
}