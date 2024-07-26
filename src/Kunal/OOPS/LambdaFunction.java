package Kunal.OOPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class LambdaFunction {
    public static void main(String[] args) {
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            ls.add(i + 2);
        }

        ls.forEach((item) -> System.out.println(item * 3));
        // before arrow argument is present, and after that the body of the function
        // is present
        // u can also store lambda functions in the variable
        // for that u have to Consumer<T> interface, with the same object type as the list.
        System.out.println();
        Consumer<Integer> function = (item) -> System.out.println(item * 4);
        ls.forEach(function);


        Operation sum = ((a, b) -> a + b);
        Operation mul = ((a, b) -> a * b);
        Operation div = ((a, b) -> a / b);

        LambdaFunction function1 = new LambdaFunction();
        int ansSum = function1.perform(3, 4, sum);
        int ansMul = function1.perform(3, 4, mul);
        int ansDiv = function1.perform(3, 4, div);
        System.out.println(ansSum);
        System.out.println(ansMul);
        System.out.println(ansDiv);
    }

    private int perform(int a, int b, Operation op){
        return op.operation(a, b);
    }
}


interface Operation{
    int operation(int a, int b);
}