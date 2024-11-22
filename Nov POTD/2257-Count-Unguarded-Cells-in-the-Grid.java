class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Initialize the grid
        int[][] grid = new int[m][n];
        for (int[] row : grid) {
            java.util.Arrays.fill(row, -1); // Mark all cells as unguarded (-1)
        }

        // Mark walls as 0
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 0;
        }

        // Mark guards as 1
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        // Traverse the grid to locate guards and explore their paths
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // Found a guard
                    // Explore all 4 directions
                    traverse(grid, m, n, i - 1, j, -1, 0); // North
                    traverse(grid, m, n, i + 1, j, 1, 0);  // South
                    traverse(grid, m, n, i, j - 1, 0, -1); // West
                    traverse(grid, m, n, i, j + 1, 0, 1);  // East
                }
            }
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    private void traverse(int[][] grid, int m, int n, int x, int y, int dx, int dy) {
        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (grid[x][y] == 0 || grid[x][y] == 1) break; // Stop at a wall or another guard
            if (grid[x][y] == -1) grid[x][y] = 2; // Mark as guarded
            x += dx;
            y += dy;
        }
    }
}
