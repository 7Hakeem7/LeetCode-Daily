class Solution {
    public int longestConsecutive(int[] nums) {
        //approach -1 : Sort the array and check for consecutive items
        // TC could be O(n logn) space /na
        //approach - 2: Take a HashMap, Hover over the nums, check if the current item +1 exists in the map.
        // TC could be O(N) for inserting into map + O(N) for traversing whole nums again.

        HashSet<Integer> set = new HashSet<>();
        int maxCnt = 0;

        //insert all into the set (assuming no duplicates given)
        for(int num : nums){
            set.add(num);
        }

        //traverse whole array to check for consecutives
        for (int num : set) {     
            if (!set.contains(num - 1)) {  // num is the start of a sequence
                int cur = num;
                int count = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                maxCnt = Math.max(maxCnt, count);
            }
        }
        return maxCnt;
    }
}