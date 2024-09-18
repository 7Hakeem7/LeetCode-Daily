class Solution {
    public int search(int[] nums, int k) {
       int low = 0 , high = nums.length-1;
       int ans = -1;
       while(low <= high){
        int mid = low + (high - low)/2;
        if(nums[mid] == k){
            return mid;
        }
        //search if left part is sorted
        if(nums[low] <= nums[mid]){
            //check if the answer lies in left
            if(nums[low]<= k && k<=nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        //search if right part is sorted
        else if(nums[mid] <= nums[high]){
            //check if the answer lies in right
            if(nums[mid]<= k && k <= nums[high]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
       }
       return ans;
    }
}
