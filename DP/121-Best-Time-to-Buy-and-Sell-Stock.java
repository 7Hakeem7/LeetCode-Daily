class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitSoFar = 0;
        int miniSoFar = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < miniSoFar){
                miniSoFar = prices[i];
            }
            int currProfit = prices[i] - miniSoFar;
            if(currProfit < 0){
                currProfit = 0;
            }
            maxProfitSoFar = Math.max(maxProfitSoFar, currProfit);
        }
        return maxProfitSoFar;
    }
}