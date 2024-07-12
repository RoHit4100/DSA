
class ReverseNum{
    static int ans = 0;
    public static void main(String[] args) {
        int n = 54122323;
        reverse(54321);
        System.out.println("reverse is: " + ans);
        int digits = (int) Math.log10(n);
        System.err.println("reverse with different method is " + reverse(n, digits));
    }

    static void reverse(int n){
        int rem = n % 10;
        if(n == 0){
            return ;
        }

        ans = (ans * 10) + rem;
        reverse(n / 10);
    }

    // using purely recursion but here I am taking power as parameter, 
    // 1234, if I wanna reverse this thing then, I have to multiply 4 * 1000 + (123 / 10), so from where I can get the power, by using number of digits
    static int reverse(int n, int digits){
        if(n % 10 == n){
            return n;
        }

        int rem = n % 10;
        return rem * (int) Math.pow(10, digits) + reverse(n / 10, digits - 1);
    }
}