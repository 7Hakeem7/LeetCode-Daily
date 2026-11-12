class Solution {
    public int subarraySum(int[] nums, int k) {
        //put 0,1 in the MAP
        //calculate the presum
        //check if presum - k present in MAP
        //if present increase the Total count++
        //and add the curr presum to the MAP for future
        //if not present Just add the curr Presum 
        //at the end return the total count;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int presum = 0;

        map.put(0,1);

        for(int i = 0; i < nums.length; i++){
            presum += nums[i];
            if(map.containsKey(presum - k)){
                cnt += map.get(presum - k);
            }

            map.put(presum, map.getOrDefault(presum,0) + 1);
        }
        return cnt;



    }
}