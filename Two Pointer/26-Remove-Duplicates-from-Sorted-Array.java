class Solution {
    public int removeDuplicates(int[] nums) {
        //two pointer - left will keep track on the unique ones,
        //right shall check for the numbers different than the curr unique elem
        //if found swap it onto the immediate right of left, then left ++
        //loop until right reached the end 
        int i = 0;

        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1 ;
        
    }
}