
// peak index of mountain array in java

class MountainArray{
    public static void main(String[] args) {
        int[] arr = {1,12,23,34,45,56,67,61,55,24};
        System.out.println(searchPeak(arr));
    }

    static int searchPeak(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid + 1] > arr[mid]){
                start = mid + 1;
            }else if(arr[mid + 1] < arr[mid]){
                end = mid;
            }
        }
        return arr[start];
    }
}