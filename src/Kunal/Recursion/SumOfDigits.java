
class SumOfDigits{
    public static void main(String[] args) {
        System.out.println(findSum(345));
    }

    static int findSum(int n){
        if(n == 0){
            return 0;
        }
        int rem = n % 10;
        return rem + findSum(n / 10);
    }
}