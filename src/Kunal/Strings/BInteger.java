package Kunal.Strings;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BInteger {
    static BigInteger factorial(int n){
        BigInteger ans = new BigInteger("1");

        for(int i = 2; i <= n; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    public static void main(String[] args) {
//        BigInteger a = new BigInteger("23432434832093840842098095832409");
//        // big number has to passed with the help of constructor and string value
//        BigInteger b = new BigInteger("9309534095348530985453893409348985305809534898509358059348098");
//        BigInteger sum = a.add(b);
//        System.out.println(sum);
//        BigInteger mul = a.multiply(b);
//        BigInteger ans = factorial(234);
//        System.out.println(ans);


        BigDecimal x = new BigDecimal("0.04");
        BigDecimal y = new BigDecimal("3");
        BigDecimal ans = x.subtract(y);
    }
}
