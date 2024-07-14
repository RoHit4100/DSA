
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class SubSet{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subSet(arr);
        System.out.println(ans);
        int[] newArr = {1,2,2};
        List<List<Integer>> newAns = subSetWithDuplicate(newArr);
        System.out.println(newAns);
        // for n length of array 2^n subset will have
    }

    static List<List<Integer>> subSet(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num: arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }

    static List<List<Integer>> subSetWithDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }else{
                start = 0;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }
}