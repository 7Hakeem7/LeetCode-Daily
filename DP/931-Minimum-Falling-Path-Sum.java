class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from the second last row and move upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                // Get the minimum from three possible paths below
                int left = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int down = matrix[i + 1][j];
                int right = (j < n - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;

                // Update the current cell with the min sum path
                matrix[i][j] += Math.min(left, Math.min(down, right));
            }
        }

        // The answer is the minimum value in the first row
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[0][j]);
        }

        return minSum;
    }
}
