
class BSInInfiniteArr{
    public static void main(String[] args){
        int[] arr = {2,4,5,6,8,9,10, 23, 34, 45, 67, 78, 89, 100};
        System.out.println(ans(arr, 34));
    }
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1; 

        while(arr[end] < target){
            int tempStart = end + 1;

            end = end + (end - start + 1) * 2;
            start = tempStart;
        }
        return bS(arr, target, start, end);
    }


    static int bS(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}