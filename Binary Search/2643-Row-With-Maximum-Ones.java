class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        var ones = 0;
        var lastRow = 0;
        for (var row = 0; row < mat.length; row++) {
            var count = 0;
            for (var col = 0; col < mat[row].length; col++) {
                count += mat[row][col];
            }
            if (count > ones) {
                ones = count;
                lastRow = row;
            }
        }
        return new int[] { lastRow, ones };
    }
}