class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        possibleCombinations(ans , list , k , n , 1);
        return ans;
    }
    public void possibleCombinations(List<List<Integer>> ans , List<Integer> list , int k , int sum , int ind){
        if(list.size() > k)return;
        else if(list.size() == k && sum == 0) ans.add(new ArrayList<>(list));
        else{
            for(int i = ind ; i <= 9 ; i++){
            list.add(i);
            possibleCombinations(ans , list , k , sum - i , i+1);
            list.remove(list.size() - 1);
        }
        }
    }
}