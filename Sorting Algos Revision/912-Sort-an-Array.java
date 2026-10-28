class Solution {
    public int[] sortArray(int[] nums) {
        //int [] sortedArr = new int[nums.length];
        //[7 ,4 ,1 ,5 ,3]
        
        for(int i = 0; i < nums.length - 1; i++){
            int mini = Integer.MAX_VALUE;
            int minInd = i;
            for(int j = i; j < nums.length; j++){
                if(nums[j] < mini){
                    mini = nums[j];
                    minInd = j;
                }
            }
            if(minInd != -1){
            swap(minInd , i, nums);
            }
        }
        return nums;
    }
    private void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}