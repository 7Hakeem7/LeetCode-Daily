class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        func(candidates , 0 , target , list , ans);
        return ans;
    }
    public void func(int[] candidates , int ind , int sum , List<Integer> list , List<List<Integer>> ans){
        if(sum == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum < 0 || ind == candidates.length){
            return;
        }
        
        list.add(candidates[ind]);
        func(candidates , ind + 1 , sum - candidates[ind] , list , ans);
        list.remove(list.size() - 1);

        while(ind + 1 < candidates.length && candidates[ind] == candidates[ind + 1]){
            ind++;
        }
        func(candidates, ind + 1, sum, list, ans);

        

    }
}