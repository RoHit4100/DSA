package Strivers.BitManipulation.Medium;

public class ConvertToBaseNeg2 {
    public String baseNeg2(int n) {
        if(n == 0){
            return "0";
        }

        StringBuilder ans = new StringBuilder(); // this wil store the answer

        // here we have to divide the given number with -2
        while(n > 0){
            int rem = n % -2;
            n /= -2;

            if(rem != 0){
                rem = rem - (-2);
                n = n + 1;
            }
            ans.append(rem);
        }

        return ans.reverse().toString();
    }
}
