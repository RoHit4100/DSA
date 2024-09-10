package Strivers.GreedyAlgorithms.Easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // sort the array
        Arrays.sort(g); // first sort the both arrays to get the cookies and greedy childrens in same way
        Arrays.sort(s);

        int m = g.length;
        int n = s.length;
        int i = 0, j = 0; // i and j will start from the first index
        while(i < m && j < n){
            if(s[j] >= g[i]){ // check if the current cookie is enough to satisfy the current child
                i++; // if yes then move ahead
            }
            j++; // no matter what happens we have to move pointer from cookie
        }

        return i; // return the index of the number of childrens are satisfied
    }
}
