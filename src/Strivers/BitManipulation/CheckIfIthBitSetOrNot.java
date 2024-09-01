package Strivers.BitManipulation;

public class CheckIfIthBitSetOrNot {
    // two ways
    public static void main(String[] args) {
        // first way is using right shift operator, another is left shift operator
        int a = 5;
        int i = 2;
        int ithBit = (a >> i) & 1;
        System.out.println(ithBit);

        // another way is using left shift operator
        if((a & (1 << i)) != 0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        // we can create a mask with left operator

        // setting the ith bit
        int setIthBit = (1 << i) | a;
        System.out.println(setIthBit);

        // clearing ith bit, we have to change 1 to 0, and if it is already 0 then dont change it
        int clearIthBit = a & (1 << i);
        System.out.println(clearIthBit);

        // toggle ith bit, reverse the bit
        int toggleBit = a ^ (1 << i);
        System.out.println(toggleBit);
    }
}
