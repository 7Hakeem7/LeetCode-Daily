class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        func(0, s, ans, list);
        return ans;
    }
    private void func(int ind, String s, List<List<String>> ans, List<String> list){
        //base case:
        //if it reaches end means we will be adding it into our final list
        //we are sure that without check if the current is a palidrom we wont move further so when we reach the end it will be a valid one only
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(ind, i, s)){
                list.add(s.substring(ind , i + 1));
                func(i + 1, s, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(int start , int end , String s){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}