class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); //prefsum % k , count
        int count = 0;
        int prefSum = 0;
        map.put(0 , 1);
        for(int i = 0; i < nums.length; i++){
            prefSum = (prefSum + nums[i]) % k;
            if(prefSum < 0) prefSum += k;

            if(map.containsKey(prefSum)){
                count += map.get(prefSum);//get the count
                map.put(prefSum, map.get(prefSum)+1);
            }
            else{
                map.put(prefSum, 1);
            }
        }
        return count;


    }
}