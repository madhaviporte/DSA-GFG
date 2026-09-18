class Solution {
    public int maxProfit(int[] prices) {
        // code here
        int start = 0;
        int end = 1;
        int maxProfit = 0;
        
        while(end<prices.length){
            while(end<prices.length && prices[end-1]<prices[end]){
                end++;
            }
            maxProfit += (prices[end-1]-prices[start]);
            start = end;
            end++;
        }
        
        return maxProfit;
    }
}