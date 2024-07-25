
class SplitArrayLargestSum{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int m = 2;
        System.out.println("Smallest sum from all sum in " + m + " chunks is:" + splitArray(arr, m));
    }

    static int splitArray(int[] arr, int allowedPieces){
        int start = 0;
        int end = 0;
        
        for(int element: arr){
            start = Math.max(start, element);
            end += element;
        }


        while(start <= end){
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            // now I have to add elements till this sum, if sum is exceeded then I have to create another array
            for(int num: arr){
                if(num + sum > mid){
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }
            if(pieces > allowedPieces){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}