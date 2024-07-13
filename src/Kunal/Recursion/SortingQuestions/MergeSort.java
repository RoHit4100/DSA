
import java.util.Arrays;


class MergeSort{
    public static void main(String[] args){
        int[] arr = {3,4,21,56,6};
        int[] ans = sort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] sort(int[] arr){
        return helper(arr);
    }

    static int[] helper(int[] arr){
        if(arr.length == 1){
            return arr; 
        }

        int mid = arr.length / 2;
        int[] left = helper(Arrays.copyOfRange(arr, 0, mid));
        int[] right = helper(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mix[k++] = left[i++];
            }else{
                mix[k++] = right[j++];
            }
        }

        // in the end if any array has remaining elements then those elements are added into the mix
        while(i < left.length){
            mix[k++] = left[i++];
        }
        while(j < right.length){
            mix[k++] = right[j++];
        }
        return mix;
    }
}