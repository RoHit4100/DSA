package Strivers.ArraysQuestions;

public class BestTimeToBuysAndSellStocks {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }


    // to find the max profit we have to keep track of minimal price till any index
    static int maxProfit(int[] arr){
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for(int num: arr){
            // this will take care of the minimal
            if(num < min){
                min = num;
            }

            // now the profit
            int profit = num - min;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
