class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int a = -1 , b = -1;
        int valueRange = n * n;
        //[ 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9 ]
        //[ 0, 1 , 1 , 1 , 1, 0 , 1, 1, 1, 2] // a = 9; b = 5;
        //initialize an arr of size n*n + 1
        int[] mapArr = new int[valueRange + 1];
        //traverse the grid, for each val in grid increment the val in mapArr
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int currIndex = grid[i][j];
                mapArr[currIndex]++;
            }
        }
        //now second traversal for missing number
        //traverse from index 1 in mapArr till end,
        for(int i = 1; i < mapArr.length; i++){
            if(mapArr[i] > 1)a = i;
            if(mapArr[i] == 0)b = i;
        }
        return new int[]{a, b};

        //check if the val in the mapArr is > 1 then consider that as repeated
        //if you find val == 0 then that index is the missing value
        
    }
}