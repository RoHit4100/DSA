package Strivers.ArraysQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderOfArray {

    // optimize solution
    static List<Integer> getLeaderOptimize(int[] arr){
        // here we will start from end to search the leader
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int leader = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--){
            if(arr[i] > leader){
                leader = arr[i];
                list.add(leader);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
//        System.out.println(getLeader(arr));
//        System.out.println(getLeaderOptimize(arr));
        replaceElements(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static  int[] replaceElements(int[] arr) {
        if(arr.length == 1){
            return arr;
        }
        int n = arr.length;
        int leader = -1;

        for(int i = n - 1; i >= 0; i--){
            if(arr[i] > leader){
                int temp = arr[i];
                arr[i] = leader;
                leader = temp;
            }else{
                arr[i] = leader;
            }
        }
        return arr;
    }
    // the leader is the element which has no greater element in his right
    // brute force approach will be taking each element and checking does this is the greatest element

    // brute force
    static List<Integer> getLeader(int[] arr){
        // check for each element, that he is the greater than all the elements present in the side of him
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            // take the next element and check for it
            boolean leader = true;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    leader = false;
                    break;
                }
            }

            if (leader){
                list.add(arr[i]);
            }
        }

        return list;
    }
}
