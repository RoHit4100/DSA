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

    public static void main(String[] args) {
        System.out.println(convertToBinary(10, new ArrayList<>()));
    }
}
