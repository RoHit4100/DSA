class Palindrome{
    public static void main(String[] args){
        int n = 12211;
        String ans;
        if(isPal(n)){
            ans = "Palindrome";
        }else{
            ans = "not Palindrome";
        }
        System.out.println("The number " + n + " is " + ans);
    }

    static boolean isPal(int n){
        String num = Integer.toString(n);
        int start = 0;
        int end = num.length() - 1;
        return num.equals(helper(num, start, end));
    }

    static boolean helper(String str, int start, int end){
        if(str.charAt(start) != str.charAt(end) || start > end){
            return false;
        }

        return helper(str, start + 1, end - 1);
    }
}