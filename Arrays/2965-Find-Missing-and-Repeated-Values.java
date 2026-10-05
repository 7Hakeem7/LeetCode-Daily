import java.util.HashSet;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;                   // values range from 1 to n*n
        int totalSum = total * (total + 1) / 2;
        int currSum = 0;
        int repNum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                currSum += val;
                if (set.contains(val)) {
                    repNum = val;
                } else {
                    set.add(val);
                }
            }
        }

        int missingNum = totalSum - currSum + repNum;
        return new int[] {repNum, missingNum};
    }
}