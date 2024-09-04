package Strivers.StacksAndQueues.Easy;

import java.util.Stack;

public class FinalPriceWithSpacialDiscountNextSmaller {

    public int[] finalPrices(int[] prices) {
        int[] discount = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[minIndex] >= prices[j]){
                    minIndex = j;
                    break;
                }
            }

            if(minIndex == i){
                discount[i] = prices[i];
            }else{
                discount[i] = prices[i] - prices[minIndex];
            }
        }
        return discount;
    }
}
