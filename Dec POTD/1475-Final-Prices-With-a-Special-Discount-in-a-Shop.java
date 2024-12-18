class Solution {
    public int[] finalPrices(int[] prices) {
        
        for(int currPrice = 0; currPrice < prices.length - 1; currPrice++){
            for(int j = currPrice + 1; j < prices.length; j++){
                if(prices[j] <= prices[currPrice]){
                    int discount = prices[currPrice] - prices[j];
                    prices[currPrice] = discount;
                    break;
                }
            }
        }
        return prices;
    }
}