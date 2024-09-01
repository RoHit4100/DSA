package Strivers.Maths.Questions;

public class PrintAllDivisors {
    public static void main(String[] args) {
        printAllDivisors(36);
    }

    // print all the divisors of n
    static void printAllDivisors(int n){
        // traverse till square root of n
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){ // means 'i' is divisor
                if(n / i != i){
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }
}
