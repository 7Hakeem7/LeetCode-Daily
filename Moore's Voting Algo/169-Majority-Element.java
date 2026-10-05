class Solution {
    public int majorityElement(int[] nums) {
        //Apply moore's voting algo for the optimal approach
        //will assume an element and inc . dec the count 
        //once cnt is 0 then assume the next element
        //at the end of array u'll have the majority ele 
        int ele = nums[0];
        int count = 1;

        for(int i = 1 ; i < nums.length; i++){
            if(count != 0){
                if(nums[i] == ele){
                    count++;
                }
                else{
                    count--;
                }
            }
            else{
                ele = nums[i];
                count = 1;
            }
        }

        //run only if problem states there may or may not be a major ele
        // int cnt1 =0;
        // for(int i =0; i < nums.length; i++){
        //     if(nums[i] == el){
        //         cnt1++;
        //     }
        // }



        return ele;
    }
}