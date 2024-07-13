class CountZeros{
    public static void main(String[] args) {
        int n = 1000;
        int count = 0;
        System.out.print(count(n, count));
    }
    static int count(int n, int count){
        if(n == 0){
            return count;
        }

        int rem = n % 10;
        if(rem == 0){
            return count(n / 10, count + 1);
        }
        return count(n / 10, count);
    }
}