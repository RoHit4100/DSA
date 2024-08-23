package Strivers.BinarySearchQuestions.BSOnNumbers;

public class SquareRootOfN {
    public static int sqrtN(long N) {
        //  Write your code here
        // we can use Binary search here
        long start = 1;
        long end = N;

        while(start <= end){
            long mid = start + (end - start) / 2;

            long sqrt = mid * mid;
            if(sqrt == N){
                return (int)mid;
            }else if(sqrt > N){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return (int)end;
    }
}
