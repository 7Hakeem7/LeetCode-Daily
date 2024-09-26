class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;
        
        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // Calculate the row and column
            int row = mid / m;
            int col = mid % m;
            
            // If target is found return true
            if (mat[row][col] == target) return true;
            else if (mat[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        
        // Return false if target is not found
        return false; 
    }
}
