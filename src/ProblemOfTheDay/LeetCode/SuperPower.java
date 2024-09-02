package ProblemOfTheDay.LeetCode;

import java.math.BigInteger;

public class SuperPower {
    // In this problem a very huge power is given, and we have to find the answer for that, we can use BigInteger class for that purpose
    public int superPow(int a, int[] b) {
        // b contains the huge power
        // first get the power as string, because BigInteger creates number using string
        StringBuilder power = new StringBuilder();
        for(int num: b){
            power.append(num);
        }
        // now we have the power, get the power in terms of BigInteger
        BigInteger pow = new BigInteger(power.toString());
        // now convert 'a', to base
        BigInteger base = new BigInteger(""+a);
        // now find the power
        BigInteger ans = base.modPow(pow, BigInteger.valueOf(1337));
        // return as int
        return ans.intValue();
    }
}
