package Strivers.GreedyAlgorithms.Easy;

import java.util.Arrays;
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int count = -1;
        Arrays.sort(coins);

        int i = coins.length - 1;
        while(i >= 0){
            if(amount >= coins[i]){
                amount -= coins[i];
                count++;
            }else{
                i--;
            }
        }

        if(count == -1){
            return count;
        }
        return count+1;
    }
}
