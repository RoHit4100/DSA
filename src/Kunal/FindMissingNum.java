package Kunal;

import java.util.*;
class FindMissingNum{
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }

//
        int n = 4;
        int[] arr = {1,2,3,5};
        System.out.println(missingNumber(n, arr));
    }

    static int missingNumber(int n, int arr[]) {
        // Your Code Here
        // Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            int correct = arr[i] - 1;
            if(correct < n && arr[i] != arr[correct]){
                return i + 1;
            }
        }
        return n + 1;
    }
}