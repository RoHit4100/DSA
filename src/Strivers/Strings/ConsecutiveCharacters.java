package Strivers.Strings;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int maxCount = 1; // take the maxCount as 1, as we are starting from first character
        int count = 1; // count will be 1, as starting from the first index of the string
        char prev = s.charAt(0);
        for(int i = 1; i < s.length(); i++){ // traverse through the string
            char ch = s.charAt(i); // take the current character
            if(ch == prev){ // compare current with prev, if same the increment the count
                count++;
            }else{ // this means character is not the same, change the prev and reset the count
                count = 1;
                prev = ch;
            }
            // update the maxCount
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
