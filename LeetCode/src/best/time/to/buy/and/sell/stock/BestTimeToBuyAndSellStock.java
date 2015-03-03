package best.time.to.buy.and.sell.stock;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int profit = 0;
        int min = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<prices[min]){
                min=i;
            }else{
                if(prices[i]-prices[min]>profit){
                    profit = prices[i] - prices[min];
                }
            }
            
        }
        return profit;
    }
}
