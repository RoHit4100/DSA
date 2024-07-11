
import java.util.ArrayList;
import java.util.List;


class FindDisappearedNumCS{
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearNum(arr);
        System.out.println(ans);
    }

    static void sort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static List<Integer> findDisappearNum(int[] arr){
        sort(arr);

        List<Integer> ls = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            if(arr[i] != i + 1){
                ls.add(i + 1);
            }
            i++;
        }
        return ls;
    }
}