package ProblemOfTheDay.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    // using dfs
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(); // this will store the ans

        for(int i = 1; i <= 9; i++){ // traverse from 1 to 9 for each number
            dfs(ans, n, i); // call dfs for each number
        }
        return ans; // return the answer
    }

    private void dfs(List<Integer> ans, int range, int cur){
        if(cur > range) return; // if current number exceeds the range then return

        ans.add(cur); // add the current number into the answer
        cur *= 10; // multiply the current with 10
        for(int i = 0; i <= 9; i++){ // traverse from 0 to 9
            dfs(ans, range, cur + i); // call dfs again by adding i
        }
    }

    public List<Integer> lexicalOrderIterative(int n) {
        int current = 1; // start with 1
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= n; i++){ // run this loop till n
            ans.add(current); // add the current into answer
            if(current * 10 <= n){ // check if, after multiplying current number still in the range or not
                current *= 10; // if yes then multiply
            }else{
                while(current % 10 == 9 || current >= n){ // if current gets out off the range, then check if that current is last in that series or not
                    // last in the series will have the 9 module, and also reduce the number if that number is greater than the n
                    current /= 10;
                }
                // add one into the number
                current += 1;
            }
        }

        return ans;
    }
}
