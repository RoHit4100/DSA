package Strivers.Recursion.Questions.Hard;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        helper(ans, new StringBuilder(), digits, 0);
        return ans;
    }


    private void helper(List<String> ans, StringBuilder p, String up, int index){
        if(p.length() == up.length()){
            ans.add(p.toString());
            return;
        }

        int digit = up.charAt(index) - '0'; // this will get the number

        // there will be 4 cases if for number 1-9
        if(digit >= 2 && digit <= 6){ // from 2 to 6 there will be 3 characters
            for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++){
                // for 2, (2 - 2) * 3 = 0  ---> (2 - 1) * 3 = 3
                char ch = (char)('a' + i); // this will give you each character which belongs to digit 2 till 6
                p.append(ch); // add current character to p
                helper(ans, p, up, index + 1);
                p.deleteCharAt(p.length() - 1); // backtrack
            }
        }else if(digit == 7){ // for 7 there will be 4 characters
            for(int i = ((digit - 2) * 3); i <= (digit - 1) * 3; i++){
                char ch = (char)('a' + i);
                p.append(ch); // add current character to p
                helper(ans, p, up, index + 1);
                p.deleteCharAt(p.length() - 1); // backtrack
            }
        }else if(digit == 8){ // for 8 there will be 3 characters
            for(int i = ((digit - 2) * 3) + 1; i <= (digit - 1) * 3; i++){
                char ch = (char)('a' + i);
                p.append(ch); // add current character to p
                helper(ans, p, up, index + 1);
                p.deleteCharAt(p.length() - 1); // backtrack
            }
        }else if(digit == 9){ // again 4 characters
            for(int i = ((digit - 2) * 3) + 1; i <= ((digit - 1) * 3) + 1; i++){
                char ch = (char)('a' + i);
                p.append(ch); // add current character to p
                helper(ans, p, up, index + 1);
                p.deleteCharAt(p.length() - 1); // backtrack
            }
        }
    }
}
