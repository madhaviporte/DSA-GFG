class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        
        for(int i=0; i<n; i++){
            if(prices[i]<buy){
                buy = prices[i];
            }
            else if(prices[i]-buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}