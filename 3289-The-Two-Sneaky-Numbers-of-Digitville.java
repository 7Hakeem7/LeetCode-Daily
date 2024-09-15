class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int [] sneakyDigits = new int [2];
        int index = 0;
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }
            else{
                sneakyDigits[index++] = num;
            }
        }
        return sneakyDigits;
        
    }
}