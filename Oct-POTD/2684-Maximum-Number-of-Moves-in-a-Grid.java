// class Solution {
//     public int maxMoves(int[][] grid) {
    //     int row = grid.length;
    //     int col = grid[i].length;
    //     int count = 0;
    //     int maxCount = 0;
    //     //row -> -1 , 0 , +1
    //     //col -> +1 , +1 , +1
    //     //col to start [i][0]
    //     for (int i = 0 ; i < row ; i++){
    //             count = maxMoves(grid , i , j);
    //     }
    //     return count;

    // }
    // private int maxMoves(int [][]grid , int row , int col){
    //     if(i > grid.length || i < 0)return;
    //     maxMoves(grid , row - 1 , col + 1);
    //     maxMoves(grid , row , col + 1);
    //     maxMoves(grid , row + 1 , col + 1);

    // }

//}
class Solution {
    private int row;
    private int col;
    private int[][] cache;
    private int[][] directions = {{-1,1},{0,1},{1,1}};
    private int[][] grid;
    public int maxMoves(int[][] grid) {
        // DFS + memo
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        cache = new int[row][col];
        int res = 0;
        for(int r = 0;r<row;r++)
        {
            
            res = Math.max(res,dfs(r,0));
            
        }
        return res;
    }

    private int dfs(int r, int c)
    {
        if(!inRange(r,c)) return 0;
        if(cache[r][c] > 0) return cache[r][c];
        int currRes = 0;
        for(int[] direction:directions)
        {
            int nextR = r+direction[0];
            int nextC = c+direction[1];
            if(inRange(nextR, nextC) && grid[nextR][nextC] > grid[r][c])
            {
                currRes = Math.max(currRes, 1+dfs(nextR, nextC));
            }
        }
        cache[r][c] = currRes;
        return currRes;
    }

    private boolean inRange(int r, int c)
    {
        return r>=0 && r < row && c>=0 && c < col;
    }

}