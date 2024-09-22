package ProblemOfTheDay.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class KthLexicographicalNum {
    class Solution {
        public int findKthNumber(int n, int k) {
            // first find the lexicography number list from 1 to n
            List<Integer> ans = new ArrayList<>();

            for(int i = 1; i <= 9; i++){
                dfs(ans, i, n);
            }

            return ans.get(k - 1);
        }

        private void dfs(List<Integer> ans, int current, int n){
            if(current > n) return;
            ans.add(current);
            current *= 10;
            for(int i = 0; i <= 9; i++){
                dfs(ans, current + i, n);
            }
        }
    }

}
