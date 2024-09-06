package Strivers.StacksAndQueues.Medium;

import java.util.Stack;

public class OnlineStockSpan {
    class StockSpanner {
        // first define the class, to store the index and the value with that index
        private class Pair{
            int first;
            int second;
            Pair(int first, int second){
                this.first = first;
                this.second = second;
            }
        }

        // maintain a index pointer to keep track of the location of that stock
        private int index = -1;
        private Stack<Pair> stack; // this will be our monotonic stack, which will store the previous greater element with its index

        public StockSpanner() {
            stack = new Stack<>(); // initialized the stack
        }

        public int next(int price) {
            // to solve this question we have to first find the previous greater that will be the better approach, but we don't need
            // to precompute that, we can just compute on the fly

            // first increase the index, as we have go the element
            index++;
            while(!stack.isEmpty() && stack.peek().first <= price){ // remove all the elements , which are lesser than the top of the stack
                stack.pop();
            }

            // no top of the stack is the prev greater for the current index
            int ans = index - (stack.isEmpty() ? -1: stack.peek().second); // now calculate the stock span, which will be the difference between the
            // current index and the index of the previous greater elements index
            Pair pair = new Pair(price, index); // create the pair with its index
            stack.push(pair); // push this pair into stack
            return ans; // return the difference
        }
    }
}
