
class LinearSearch{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,7,87};
        System.out.println(check(arr, 0, 777));
        System.out.println(checkAndGetIndex(arr, 0, 7));
        System.out.println(check2(arr, 0, 877));
    }

    static boolean check(int[] arr, int index, int target){
        if(arr[index] == target){
            return true;
        }
        if(index == arr.length - 1){
            return false;
        }
        return check(arr, index + 1, target);
    }

    static boolean check2(int[] arr, int index, int target){
        if(index > arr.length - 1){
            return false;
        }
        return arr[index] == target || check2(arr, index + 1, target);
    }

    static int checkAndGetIndex(int[] arr, int index, int target){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return checkAndGetIndex(arr, index + 1, target);
    }

}  