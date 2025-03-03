class Solution {
    public int currPos = 0;
    public int[] pivotArray(int[] nums, int pivot) {
        //my brute force approach is 
        int[] ans = new int[nums.length];
        //three traversal where
        //traverse for elements < Pivot and add to ans arr
        leftPart(nums, pivot, ans);
        //traverse for elements == Pivot and add to ans arr
        middlePart(nums, pivot, ans);
        //traverse for elements > Pivot and add to ans arr
        rightPart(nums, pivot, ans);
        //return the array
        return ans;
    }
    private void leftPart(int[] nums, int pivot, int[] ans){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                ans[currPos] = nums[i];
                currPos++;
            }
        }
    }
    private void middlePart(int[] nums, int pivot, int[] ans){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == pivot){
                ans[currPos] = nums[i];
                currPos++;
            }
        }
    }
    private void rightPart(int[] nums, int pivot, int[] ans){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > pivot){
                ans[currPos] = nums[i];
                currPos++;
            }
        }
    }
}