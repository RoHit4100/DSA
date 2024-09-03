package Strivers.StacksAndQueues.Easy;

import java.util.Stack;

public class FinalPriceWithSpacialDiscountNextSmaller {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = prices[i];
            }else{
                ans[i] = stack.peek();
            }
            stack.push(prices[i]);
        }

        return ans;
    }
}
