class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int i=0;
        while(i < nums.length){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                int num = nums[j];
                if(set.contains(num)){
                    count++;
                    
                    break;
                }
                set.add(num);
            }
            i += 3;
        }
        return count;
    }
}