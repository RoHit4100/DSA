package Strivers.Strings;

public class LargestOddInString {
    // brute force solution
    public String largestOddNumber(String num) {
        long number = Long.parseLong(num);

        // now go through each digit and check if that number is odd or not
        long maxOdd = 0;
        while(number > 0){
            // System.out.println(number);
            if((number & 1) == 1){
                maxOdd = Math.max(maxOdd, number);
            }
            number /= 10;
        }

        if(maxOdd == 0) return "";
        return String.valueOf(maxOdd);
    }

    // optimal solution
    public String largestOddNumberOptimal(String num) {
        // start from the end, and check if any digit from the end is odd or not, if yes then return the string
        // starting from 0 to end
        for(int i = num.length() - 1; i >= 0; i--){
            // check if the current digit is odd or not
            int digit = num.charAt(i) - '0';
            if((digit & 1) == 1){  // if digit is odd then return the substring starting from 0 to i
                return num.substring(0, i + 1); // i + 1, because last index is exclusive
            }
        }
        return "";
    }
}
