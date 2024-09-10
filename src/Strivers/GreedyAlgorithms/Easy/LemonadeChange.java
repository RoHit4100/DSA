package Strivers.GreedyAlgorithms.Easy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0; // this variables will keep track of the number of 5's and 10's bills

        for(int bill: bills){ // traverse for each bill
            if(bill == 5){ // if bill is 5, then we can just give him lemonade, and increase the 5
                fives++;
            }else if(bill == 10){ // If bill is 10, then we have to give him lemonade and give him 5 dollars, if not then return false
                // in this case I should have at least 1 five
                if(fives > 0){ // check if we have change of 5 dollars or not
                    tens++; // if yes then increase the 10 dollar bills
                    fives--; // reduce the 5 dollars, as we have return him
                }else {
                    return false; // if we don't have 5 dollars then return false
                }
            }else if(bill == 20){
                // in this case I should have at least, 1 ten and 1 5 five, or at least 3 fives
                if(fives > 0 && tens > 0){ // check if we have at least 1 five dollar and 1 ten dollar
                    fives--;
                    tens--;
                }else if(fives >= 3){ // check if we have more than 3 five dollars
                    fives -= 3;
                }else{ // if not then return false
                    return false;
                }
            }
        }
        // if we are successfully able to content the customers then return true
        return true;
    }
}
