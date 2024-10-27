class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int count=0;
        for(int rowStart=0;rowStart<rowCount;rowStart++){
            int[] subMatrix = new int[colCount];
            for(int row=rowStart;row<rowCount;row++){
                for(int col=0;col<colCount;col++){
                    subMatrix[col]+=matrix[row][col];
                }
                count+=getCount(subMatrix,row-rowStart+1);
            }
        }
        return count;
    }
    
    public int getCount(int[] matrix, int side){
        int[] preMatrix = new int[matrix.length];
        preMatrix[0]=matrix[0];
        for(int idx=1;idx<matrix.length;idx++){
            preMatrix[idx]=preMatrix[idx-1]+matrix[idx];
        }
        int count=0;
        for(int idx=0;idx<matrix.length-side+1;idx++){
            int left = idx==0?0:preMatrix[idx-1];
            int right = preMatrix[idx+side-1];
            int sum = right-left;
            if(sum==side*side){
                count++;
            }
        }
        return count;
    }
}