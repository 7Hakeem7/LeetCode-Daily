// class Solution {
//     public int[][] highestPeak(int[][] isWater) {
        //initialize a new matrix with zeroes
        //traverse for water cells and mark all the adjacents as 1 and the water cells as -1
        //after that traverse again now wherever there is a 0 check for all the four directions to increment that value while maintaining diefference between the adjacent cell is at most 1. we need to maximize this
//     }
// }

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        
        // Initialize the height matrix with -1 for land cells and 0 for water cells
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }
        
        // Directions array for traversing up, down, left, and right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        
        // Add all water cells to the queue as the starting points
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        // Perform BFS to calculate heights
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // Check if the new cell is within bounds and unvisited
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        return height;
    }
}
