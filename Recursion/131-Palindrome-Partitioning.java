class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        generate(s, 0 , ans , list);
        return ans;
    }
    private void generate(String s , int ind , List<List<String>> ans , List<String> list){
        int n = s.length();
        if(ind == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = ind ; j <= n-1 ; j++){
            if(isPalindrome(s, ind , j)){
                String substr = s.substring(ind , j + 1);
                list.add(substr);
                generate(s , j + 1 , ans , list);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s , int left , int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}