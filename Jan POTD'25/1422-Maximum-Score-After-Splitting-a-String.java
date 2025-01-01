class Solution {
    public int maxScore(String s) {
        int onesCount = 0;
        int zeroesCount = 0;
        for(int i = 0; i < s.length(); i++){
            //presum of no of ones
            if(s.charAt(i) == '1'){
                onesCount++;
            }
        }
        int maxScore = 0;
        //traverse from left to right
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '0')zeroesCount++;
            else onesCount--;

            if(onesCount + zeroesCount > maxScore){
                maxScore = onesCount + zeroesCount;
            }
        }
        return maxScore;
    }
}