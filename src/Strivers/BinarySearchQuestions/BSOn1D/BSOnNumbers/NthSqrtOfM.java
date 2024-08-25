package Strivers.BinarySearchQuestions.BSOn1D.BSOnNumbers;

public class NthSqrtOfM {
    // optimal approach will be using BS as we are working in range
    static int NthRootOptimized(int n, int m){
        int start = 1;
        int end = m;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int condition = findPower(mid, n, m);
            if(condition == 1){
                return mid;
            }else if(condition == 0){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
    //Return 1 if mid == m
    //Return 0 if mid < m
    //Return 2 if mid > m
    static int findPower(int b, int n,int m){
        long ans = 1;
        for(int i = 1; i <= n; i++){
            ans = ans * b;
            if(ans > m){
                return 2;
            }
        }
        if(ans == m){
            return 1;
        }
        return 0;
    }



    // power exponential method
    // this method is used to find the value of N with power M
    static long findPower(int b, int exponent){
        long base = b;
        long ans = 1;

        while (exponent > 0){
            if(exponent % 2 == 1){
                // when exponent is odd then we have to reduce the exponent by one and multiply the ans with base
                exponent--;
                ans *= base;
            }else{
                // if even then take square of base, and divide the exponent by 2
                exponent /= 2;
                base = base * base;
            }
        }
        return ans;
    }


    // brute force approach to find the square root of n with power m
    // is performing linear search from 1 to n
    static int NthRoot(int n, int m){ // n --> power , m --> square
        for(int i = 1; i <= m; i++){
            long power = findPower(i, n);
            if((long)m == power){
                return i;
            }
            if(power > (long)m){
                break;
            }
        }
        return -1;
    }
}
