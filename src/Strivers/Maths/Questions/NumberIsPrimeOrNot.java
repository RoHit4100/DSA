package Strivers.Maths.Questions;

public class NumberIsPrimeOrNot {
    public static void main(String[] args) {
        System.out.println(isPrime(4));
    }

    static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
