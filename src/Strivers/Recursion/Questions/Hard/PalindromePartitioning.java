package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        helper(ans, partition, s, 0);
        return ans;
    }

    private void helper(List<List<String>> ans, List<String> partition, String up, int index){
        if(index == up.length()){
            ans.add(new ArrayList<>(partition));
            return;
        }
        for(int i = index; i < up.length(); i++){
            // first check the partition that we are going to create is palindrome or not
            if(i == index || isPalindrome(up, index, i)){
                // if this partition is valid palindrome then add that partition into partition list
                partition.add(up.substring(index, i + 1)); // add the partition, which is the substring
                helper(ans, partition, up, i + 1);
                // remove the last added partition
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
