package Strivers.BitManipulation;

public class ConvertBinaryToDecimal {
    static int getDecimal(String s){
        int power = 1;
        int result = 0;
        for(int i = s.length() - 1; i >= 0 ; i--){
            if(s.charAt(i) == '1'){
                result += power;
            }
            power *= 2;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getDecimal("1010"));
    }
}
