import java.util.ArrayList;


class FindIndexOfDuplicates{
    public static void main(String[] args){
        ArrayList<Integer> ls = new ArrayList<>();
        int[] arr = {22,3,5,5,6,4,5,5,54,4444};
        int target = 5;
        check(arr, ls, 0, target);
        System.out.println(ls);

        System.out.println(check(arr, 0, target));
    }

    static void check(int[] arr, ArrayList<Integer> list, int index, int target){
        if(index == arr.length){
            return;
        }

        if(arr[index] == target){
            list.add(index);
        }
        check(arr, list, index + 1, target);
    }


    // now we will create a new arraylist for each and every different function call, this is not optimize but we are implement this thing to just
    // understand the recursion in better way, maybe future problem can use this things.

    static ArrayList<Integer> check(int[] arr, int index, int target){
        ArrayList<Integer> ls = new ArrayList<>();
        if(index == arr.length){
            return ls;
        }

        if(arr[index] == target){
            ls.add(index);
        }

        ArrayList ansFromBelowCalls= check(arr, index + 1, target);
        ls.addAll(ansFromBelowCalls);
        return ls;
    }
}