package Kunal;

import java.util.ArrayList;
import java.util.Scanner;

class ArrayLeader{
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = sc.nextInt();
//        }
//
        int[] arr = {31 ,40, 93, 40, 98};
        System.out.println(findLeader(arr));
    }

    static ArrayList<Integer> findLeader(int[] arr){
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++){
            boolean isLeader = true;
            for(int j = i + 1; j < arr.length - 1; j++){
                if(arr[i] <= arr[j]){
                    isLeader = false;
                    break;
                }
            }
            if(isLeader){
                ls.add(arr[i]);
            }
        }
        ls.add(arr[arr.length - 1]);
        return ls;
    }
}