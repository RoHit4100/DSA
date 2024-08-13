package Strivers.Hashing;

import java.util.Arrays;

public class Hashing {

    static void frequencyOfEachNum(int[] arr){
        int[] hash = new int[7];

        System.out.println(Arrays.toString(hash));
        // now count the frequency of each number
        // means u have to increase the freq by 1 each time u encounter that element
        for(int num: arr){
            hash[num]++;
        }
        System.out.println(Arrays.toString(hash));
    }

    static void hashASCII(String s){
        int[] hash = new int[256];

        for(char ch: s.toCharArray()){
            hash[ch]++;
        }

        for(int i = 0; i < hash.length; i++){
            if(hash[i] != 0){
                System.out.print((char)i + " -> " + hash[i] + " | ");
            }
//            System.out.println();
        }
    }
    public static void main(String[] args) {
//        int[] arr = {2,1,2,2,4,5};
//        frequencyOfEachNum(arr);


        // character hashing
        String str = "A00aalfkasjklfjsakljkljkljklasjsalkfsjafklsajfkolaz";
//        int[] hash = new int[26];

        hashASCII(str);

//        for(char ch: str.toCharArray()){
//            int index = ch - 'a';
//            hash[index]++;
//        }
//
//        System.out.println(Arrays.toString(hash));
    }
}
