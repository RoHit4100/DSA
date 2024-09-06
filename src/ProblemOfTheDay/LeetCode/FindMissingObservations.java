package ProblemOfTheDay.LeetCode;

import java.util.Arrays;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];
        // first get the sum of teh rolls
        int sum = Arrays.stream(rolls).sum();

        // now find the total missing value
        int missing = mean * 6 - sum;

        // now we have to distribute this value int to parts
        int value = missing  / n;
        Arrays.fill(ans, value);
        if(value == 6){
            return ans;
        }
        int remaining = missing % n;
        if(remaining == 0){
            return ans;
        }

        // now fill the remaining part equally into the ans
        while(remaining > 0){
            int i = 0;
            while(i < ans.length) {
                if (ans[i] < 6) {
                    ans[i]++;
                    remaining--;
                }
                i++;
            }
        }

        return ans;
    }
}
