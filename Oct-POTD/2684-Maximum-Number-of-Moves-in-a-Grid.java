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
    
    private int maxMoves = 0;
    
    private int[][] dirs = {{-1,1}, {0,1}, {1,1}};
    
    public int maxMoves(int[][] grid) {
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            dfs(i, 0, grid, 0, vis);
        }
        
        return maxMoves;
    }
    
    void dfs(int row, int col , int[][] grid, int moves, boolean[][] vis){
        maxMoves = Math.max(moves, maxMoves);
        vis[row][col] = true;
        
        for(int[] dir : dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            
            if(nRow == -1 || nRow == grid.length || nCol == grid[nRow].length || grid[nRow][nCol] <= grid[row][col] || vis[nRow][nCol]){
                continue;
            }
            
            dfs(nRow, nCol, grid, moves+1, vis);
        }
    }
}