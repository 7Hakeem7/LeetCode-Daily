class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;//no of rows
        int m = matrix[0].length;//no of coloumns
        int left = 0;
        int right = m - 1;
        int bottom = n - 1;
        int top = 0;

        while(top <= bottom && left <= right){
            //left to right with top row as const
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            //top to bottom with right col as const
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            //from right to left as bottom row as const
            if(top <= bottom){
            for(int i = right; i >= left; i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            }

            //from bottom to top with left col as const
            if(left <= right){
            for(int i = bottom; i >= top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
            }
        }
        return ans;

    }
}