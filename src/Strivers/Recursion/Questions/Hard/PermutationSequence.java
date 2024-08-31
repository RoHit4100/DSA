package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        // first find the factorial of n
        int fact = 1;
        // create list to store the initial permutation
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < n; i++){ // factorial or 3 if given is 4
            fact = fact * i; // count the fact
            list.add(i); // add the current number into the factorial
        }
        list.add(n); // add the last element into the list
        // create String for return
        StringBuilder ans = new StringBuilder();
        k = k - 1; // as we are working in 0 based indexing

        while (true){
            int currentLocation = k / fact; // get the first number, 16 / 6 == 2
            ans.append(list.get(currentLocation)); // add that element into the answer
            list.remove(currentLocation); // remove the added element

            if(list.isEmpty()){
                break;
            }

            k = k % fact; // get the next k, 16 % 6 == 4, next k will be 6
            fact = fact / list.size(); // reduce as the size of the next permute block will also decrease.
        }

        return ans.toString();
    }
}
