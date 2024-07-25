
class FibonacciSeries{
    public static void main(String[] args) {
        int n = 80;
        System.out.println(fiboFormula(n));
    }


    static long fiboFormula(int n){
        return (long)(Math.pow((1 + Math.sqrt(5)) / 2, n) / (1 + Math.sqrt(5)));
    }
    // this is using recursion but time complexity for this function is very high.
    static int fibo(int n){
        if(n < 2){
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}

// the formula for nth fibonacci number is, (1 + root(5) / 2) ^ 2 / 1 + root(5).