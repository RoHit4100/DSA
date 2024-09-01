package Strivers.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class ConvertADecimalIntoBinary {
    // using recursion
    private static List<Integer> convertToBinary(int n, List<Integer> list){
        if(n == 0){
            return list;
        }

        int rem = n % 2;
        convertToBinary(n / 2, list);
        list.add(rem);
        return list;
    }

    public static String convertToBinary(int n) {
        // Base case: when the number becomes 0, return an empty string
        if (n == 0) {
            return "";
        }

        // Recursive case: divide the number by 2 and concatenate the remainder (0 or 1)
        return convertToBinary(n / 2) + (n % 2);
    }

    public static String binary(int n){
        StringBuilder ans = new StringBuilder();

        while(n != 0){
            int rem = n % 2;
            if(rem == 1){
                ans.append("1");
            }else {
                ans.append("0");
            }
            n /= 2;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(10, new ArrayList<>()));
        System.out.println(binary(10));
    }
}
