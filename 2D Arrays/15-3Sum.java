class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //we first sort to avoid duplicate set
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //traverse the array till the end
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            int j = i + 1;
            int k = nums.length - 1;
            //take the curr threeSum
            while(j < k){
            int sum = nums[i] + nums[j] + nums[k];
            if(sum < 0){
                //if curr sum is -ve we need to move towards +ve to make the whole sum to 0
                j++;
            }
            else if(sum > 0){
                //if curr sum is +ve we need to reduce to get it to sum 0
                k--;
            }
            else{
                //means we have the curr sum = 0
                //add it to the List
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                //after adding 
                k--;
                j++;
                while(j < k && nums[k] == nums[k+1]){
                    k--;
                }
                while(j < k && nums[j] == nums[j - 1]){
                    j++;
                }

            }
            }

        }
        return result;
    }
}