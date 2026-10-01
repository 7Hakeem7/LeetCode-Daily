class Solution {
    public void sortColors(int[] nums) {
        //dutch national flag algo 
        //Du Du Du DU Max Verstappen
        //-infinity to Low - 1 0s
        //low to mid 1s
        //mid + 1 to high unsorted
        //high + 1 to +infinity 2s

        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
            
                high--;
            }
        }

    }
}