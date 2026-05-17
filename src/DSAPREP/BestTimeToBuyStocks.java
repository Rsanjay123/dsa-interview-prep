package DSAPREP;

import java.util.List;

public class BestTimeToBuyStocks {
  public static void main(String[] args) {
    List<Integer> prices = List.of(7, 1, 5, 3, 6, 4);
    System.out.println(maxProfit2(prices));
    System.out.println(maxProfit(prices));
  }

  private static int maxProfit(List<Integer> prices) {
    int profit = 0;
    for(int i = 1; i < prices.size(); i++) {
      int diff = prices.get(i) - prices.get(i - 1);
      if(diff > 0) {
        profit += diff;
      }
    }
    return profit;
  }

  private static int maxProfit2(List<Integer> prices) {
    int minValue = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int price: prices) {
      if(price < minValue) {
        minValue = price;
      } else {
        int profit = price - minValue;
        if(profit > maxProfit) {
          maxProfit = profit;
        }
      }
    }
    return maxProfit;
  }
}
