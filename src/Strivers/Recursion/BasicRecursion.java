package Strivers.Recursion;

import javax.print.attribute.standard.PresentationDirection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BasicRecursion {
    // reverse array with recursion
    static void reverseArray(int[] arr, int index){
        // run this recursion till index is greater than or equal to mid
        if(index >= arr.length){
            return;
        }

        // or else swap first and last index
        swap(arr, index, arr.length - index - 1);
        reverseArray(arr, index + 1);
    }

    static String reverse(String s, int index, StringBuilder ans) {
        // keep track of index
        if (index < 0) {
            // return the ans
            return ans.toString();
        }
        // append the ans with the current index, 5,4,3,2,1,0
        ans.append(s.charAt(index));

        // call the recursive function
        return reverse(s, index - 1, ans);
    }

    private static String reverse(String s){
        if(s.isEmpty()){
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
    }
    private static void swap(int[] arr, int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static boolean palindrome(String s, int index){
        if(index >= s.length() / 2){
            return true;
        }

        return s.charAt(index) == s.charAt(s.length() - index - 1) && palindrome(s, index + 1);
    }
    public static void main(String[] args) {
        String str = "naman";
//        System.out.println(reverse(str));
        System.out.println(palindrome(str, 0));
//        StringBuilder ans = new StringBuilder();
////        System.out.println(reverse(str, str.length() - 1, ans));
//        reverse(str, str.length() - 1, ans);
//        System.out.println(ans);

//        System.out.println(sumOfN(5));
//        System.out.println(sum(5));
//        System.out.println(factorialOfN(5));
        int[] arr = {5,4,3,2,1};
        reverseArray(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static int factorialOfN(int n){
        if(n == 1){
            return 1;
        }

        return n * factorialOfN(n - 1);
    }

    static void print(int index){
        if(index == 5){
            System.out.println(index);
            return;
        }

        print(index + 1);
        System.out.println(index);
    }

    static int sumOfN(int n){
        if(n == 1) {
            return 1;
        }

        int sum = n;
        sum += sumOfN(n - 1);
        return sum;
    }

    static int sum(int n){
        if(n == 1){
            return 1;
        }

        return n + sum(n - 1);
    }
}
