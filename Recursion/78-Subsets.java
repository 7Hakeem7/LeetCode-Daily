class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generateSubsets(0 , list , ans , nums , nums.length);
        return ans;
    }
    private void generateSubsets(int ind , List<Integer> list , List<List<Integer>> ans , int[] nums , int n){
        if(ind == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        generateSubsets(ind + 1 , list , ans , nums , n);
        list.remove(list.size() - 1);

        generateSubsets(ind + 1 , list , ans , nums , n);
    }
}