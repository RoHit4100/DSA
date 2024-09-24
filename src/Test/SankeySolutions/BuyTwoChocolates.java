package Test.SankeySolutions;

import java.util.Arrays;

public class BuyTwoChocolates {
    // find the min and second min, from the array
    public int buyChocoOptimal(int[] prices, int money) {
        // now this will be the optimal solution
        // find 2 smallest elements
        int min = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;

        for(int price : prices){
            if(min > price){ // check if the current is min or not
                sMin = min;
                min = price; // if yes then initialize the min and second min
            }else if(sMin > min && sMin > price){
                sMin = price; // update the second min
            }
        }

        if(min + sMin <= money) return money - min - sMin; // if we can buy the chocolate then return the remaining amount
        return money; // else return the money
    }

    // this will be the brute force solutions, which will have the time complexity of n log n + n
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices); // first sort the array
        int original = money; // save the original money
        for(int i = 0; i < 2; i++){ // because we have to find only two chocolates
            if(money - prices[i] < 0){ // buy the chocolate if we have to enough money
                return original; // return original money, if we aren't able to buy the chocolate
            }else if(money - prices[i] == 0){ // if we are successfully able to buy the chocolate return money
                if(i == 0) return prices[i]; // if we can buy only one chocolate return the money required for that chocolate
                return 0; // else return 0
            }
            money -= prices[i]; // reduce the money after buying chocolate
        }
        return money; // this will be dummy return statement
    }
}
