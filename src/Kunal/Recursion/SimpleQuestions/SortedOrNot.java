class SortedOrNot{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4};
        System.out.println(check(arr));
    }

    static boolean check(int[] arr){
        return helper(arr, 0);
    }

    static boolean helper(int[] arr, int start, int end){
        if(start == end){
            return true;
        }
        if(arr[start] < arr[start + 1]){
            return helper(arr, start + 1, end);
        }else{
            return false;
        }
    }


    static boolean helper(int[] arr, int i){
        if(i == arr.length - 1){
            return true;
        }

        return arr[i] <= arr[i + 1] && helper(arr, i + 1);
    }
}