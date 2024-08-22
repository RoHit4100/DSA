package Strivers.ArraysQuestions;


import java.util.*;

public class MajorityElementVersion2 {
    // optimal approach will be using two pointer method from the start of the array
    static List<Integer> majorityElement(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int majority = arr.length / 3;
        // nwo take two pointers for traversing and 2 for inserting those elements into the ans
        int cnt1 = 0, cnt2 = 0;
        int e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE;

        // in this problem we will use the intuition of first version of this problem. and use two pointers instead of 1
        for(int num: arr){
            if(cnt1 == 0 && num != e2){
                cnt1++;
                e1 = num;
            }else if(cnt2 == 0 && e1 != num){
                cnt2++;
                e2 = num;
            }else if(num == e1){
                cnt1++;
            }else if(num == e2){
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }

        // now manually get teh count of those two identified elements
        cnt1 = 0;
        cnt2 = 0;
        for (int num: arr){
            if(num == e1){
                cnt1++;
            }else if(num == e2){
                cnt2++;
            }
        }


        if(cnt1 > majority){
            ans.add(e1);
        }
        if(cnt2 > majority){
            ans.add(e2);
        }


        return ans;
    }


    // better solution will use the hashing, in which we can count the frequency of each element
    static List<Integer> majorityElementHashing(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        // now insert every element into the array, and check each time if the frequency becomes greater than the majority
        int majority = arr.length / 3;
        for (int num: arr){
            int freq = map.getOrDefault(num, 0) + 1;
            if(!ans.contains(num) && freq > majority){
                ans.add(num);
                continue;
            }
            map.put(num, freq);
            if(ans.size() == 2){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2};
        System.out.println(majorityElementBruteForce(arr));
        System.out.println(majorityElementHashing(arr));
        System.out.println(majorityElement(arr));
    }

    // this is the brute force approach where I will check all the elements of array and count each on of them
    static List<Integer> majorityElementBruteForce(int[] arr){
        int majority = arr.length / 3;
        System.out.println(majority);
        List<Integer> ans = new ArrayList<>();

        int count = 1; // this will maintain the count for each element
        // now find the frequency of each number
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > majority && !ans.contains(arr[i])){
                ans.add(arr[i]);
            }
            count = 1;
            // WE KNOW THAT, length of the list will be exactly 2, so we will just check,
            if(ans.size() == 2){
                break;
            }
        }
        return ans;
    }
}
