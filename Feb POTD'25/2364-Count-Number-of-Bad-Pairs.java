class Solution {
    public long countBadPairs(int[] nums) {
        // long ans = 0;
        // for(int i = 0; i < nums.length - 1; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         if(nums[i] - i != nums[j] - j){
        //             ans++;
        //         }
        //     }
        // }
        // return ans;
        //0  1  2  3  4  5  6
        //4, 6, 2, 8, 3, 5, 6
        //4, 5, 0, 5, -1, 0, 0

        long goodPairs = 0;
        long n = nums.length;
        long totalPairs = n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int val = nums[i] - i;
            goodPairs += map.getOrDefault(val,0);
            map.put(val , map.getOrDefault(val,0) + 1);
        }
        return totalPairs - goodPairs;
    }
}