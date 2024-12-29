class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        func(0 , "" , 0 , 0 , list , n);
        return list;
    }
    private void func(int ind , String s , int open, int close, List<String> list, int n){
        if(open > n)return;
        if(open + close == 2*n && open == close){
            list.add(s);
            return;
        }
        if(open < n)func(ind + 1, s + '(', open + 1 , close , list , n);
        if(close < open)func(ind + 1, s + ')' , open , close + 1, list , n);
    }
}