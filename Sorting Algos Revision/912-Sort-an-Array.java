class Solution {
    public int[] sortArray(int[] nums) {
        //int [] sortedArr = new int[nums.length];
        //[7 ,4 ,1 ,5 ,3]
        
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j <= i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
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