class Solution {
    public int countServers(int[][] grid) {
        //initialize the ans to 0
        int ans = 0;
        //initialize row count array of size of rows
        int[] rowCount = new int[grid.length];
        //initialize col count array of size of cols
        int[] colCount = new int[grid[0].length];
        //traverse the grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
            //if you see a '1' increment the i cnt in row and j cnt in col
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                    ans++;
                    
                }
            }
        }
        System.out.println(ans);
        
        //do a second traversal 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
            //this time for (i,j) check if both the rowcount and colcount
            //if either of them is not > 1 then ans--;
                if(grid[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    ans--;
                }
            }
        }
        return ans;
    }
}