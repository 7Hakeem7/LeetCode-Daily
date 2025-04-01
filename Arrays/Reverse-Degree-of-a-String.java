class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        for(int i = 0; i < s.length(); i++){
            int currSum = (26 - (s.charAt(i) - 'a')) * (i + 1);
            totalSum += currSum;
        }
        return totalSum;
    }
}