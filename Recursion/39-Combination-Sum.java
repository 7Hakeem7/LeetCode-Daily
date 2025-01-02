class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        func(0 , candidates , target , list , ans);
        return ans;
    }
    private void func(int ind , int[] candidates , int k , List<Integer> list , List<List<Integer>> ans){
        //base cases:
        // if(ind == candidates.length && k == 0){
        //     ans.add(new ArrayList<>(list));
        //     return;
        // }
        if(k < 0 || ind == candidates.length){
            return;
        }
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[ind]);
        func(ind , candidates , k - candidates[ind], list, ans);
        list.remove(list.size() - 1);

        func(ind + 1 , candidates, k, list,ans);
    }
}