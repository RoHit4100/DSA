
class FindDuplicateNumCS{
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.err.println("Duplicate number is " + findDuplicate(arr));
    }

    static int findDuplicate(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] != i + 1){
                int correct = arr[i] - 1;
                if(arr[i] != arr[correct]){
                    swap(arr, i, correct);
                }else{
                    return arr[i];
                }
            }else{
                i++;
            }
        }

        // now search for the duplicate

        return -1;
    }

    // static int getAns(int[] arr){
    //     for(int i = 0; i < arr.length; i++){
    //         if(arr[i] != i + 1){
    //             return arr[i];
    //         }
    //     }
    //     return -1;
    // }


    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}