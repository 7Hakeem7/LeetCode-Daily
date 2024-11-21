class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];
        for (int[] guard : guards) {
            int y = guard[0], x = guard[1];
            arr[y][x] = 1;
        }
        for (int[] wall : walls) {
            int y = wall[0], x = wall[1];
            arr[y][x] = 2;
        }
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int cnt = 0;
        for (int[] guard : guards) {
            for (int[] dir : dirs) {
                int y = guard[0], x = guard[1];
                while (true) {
                    y += dir[0];
                    x += dir[1];
                    if (y < 0 || x < 0 || y == m || x == n || arr[y][x] > 0) {
                        break;
                    }
                    if (arr[y][x] == 0) {
                        cnt++;
                    }
                    arr[y][x]--;
                }
            }
        }
        return m * n - guards.length - walls.length - cnt;
    }
}