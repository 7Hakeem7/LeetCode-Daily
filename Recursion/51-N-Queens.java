class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(s);
        }
        func(0 , ans , board);
        return ans;
    }
    private void func(int col , List<List<String>> ans , List<String> board){
        if(col == board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row = 0 ; row < board.size() ; row++){
            if(isplacingPossible(board , row , col)){
                char[] charArray = board.get(row).toCharArray();
                charArray[col] = 'Q';
                board.set(row , new String(charArray));
                func(col + 1 , ans , board);
                charArray[col] = '.';
                board.set(row , new String(charArray));
            }
        }
    }
    private boolean isplacingPossible(List<String> board , int row , int col){
        int r = row, c = col;

        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while (c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            c--;
        }
        r = row;
        c = col;
        while (r < board.size() && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r++;
            c--;
        }
        return true;
    }
}