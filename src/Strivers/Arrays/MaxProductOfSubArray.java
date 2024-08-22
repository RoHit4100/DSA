package Strivers.Arrays;

public class MaxProductOfSubArray {
    // optimal approach
    public int maxProductOptimal(int[] arr){
        int maxProduct = Integer.MIN_VALUE;

        int pre = 1;
        int suf = 1;
        for(int i = 0; i < arr.length; i++){
            if(pre == 0){
                pre = 1;
            }
            if(suf == 0){
                suf = 1;
            }


            // now get the product
            pre *= arr[i];
            suf *= arr[arr.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(pre, suf));
        }
        return maxProduct;
    }

    // brute force approach of O(n2)
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        // find all the sub Arrays
        for(int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = i; j < nums.length; j++){
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }
}
