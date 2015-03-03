package best.time.to.buy.and.sell.stock.three;

public class BestTimeToBuyAndSellStockThree {
	public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int len = prices.length;
        int[] l = new int[len];
        int[] r = new int[len];
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<len;i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
            l[i] = max;
        }
        
        max = 0;
        int ma = Integer.MIN_VALUE;
        for(int i=len-1;i>=0;i--){
            ma = Math.max(ma, prices[i]);
            max = Math.max(max, ma-prices[i]);
            r[i] = max;
        }
        int res = 0;
        for(int i=0;i<len;i++){
            res = Math.max(res, r[i]+l[i]);
        }
        return res;
    }
}
