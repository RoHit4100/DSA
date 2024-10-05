package ForFun;

public class PlusOne {
    // first convert these digits into number and then into answer
    // this will be the brute force solution
    public int[] plusOne(int[] digits) {
        long number = 0;
        for(int i = 0; i < digits.length; i++){
            number = number * 10 + digits[i];
        }

        System.out.println(number);
        number += 1;
        int totalDigits = (int)(Math.log10(number) + 1);
        int[] ans = new int[totalDigits];

        for(int i = totalDigits - 1; i >= 0; i--){
            int rem = (int) (number % 10);
            ans[i] = rem;
            number/=10;
        }
        return ans;
    }

    public int[] plusOneOptimal(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
                // starting from extreme right--> if array[i] is less than 9 means can be added with 1
                // i.e. [ 5,8 ]-->[ 5,9 ] or
                //      [ 9,4 ]-->[ 9,5 ] or
                //      [ 6,0 ]-->[ 6,1 ]
                // and will directly return array
            }
            digits[i] = 0;
            // if array[i] is not less than 9, means it have to be 9 only then digit is changed to 0,
            // and we again revolve around loop to check for number if less than 9 or not
            // i.e. [ 5,9 ]-->[ 5,0 ]-loop->[ 6,0 ] or
            //      [ 1,9,9 ]-->[ 1,9,0 ]-loop->[ 1,0,0 ]-loop->[ 2,0,0 ]
            // and will directly return array
        }

// if all number inside array are 9
// i.e. [ 9,9,9,9 ] than according to above loop it will become [ 0,0,0,0 ]
// but we have to make it like this [ 9,9,9,9 ]-->[ 1,0,0,0,0 ]


// to make like above we need to make new array of length--> n+1
// by default new array values are set to -->0 only
// thus just changed first value of array to 1 and return the array

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
