package Kunal.Strings;

import java.util.Arrays;

public class SBuffer {
    public static void main(String[] args) {
        String name = "Rohit Udamale";
        StringBuffer buffer = new StringBuffer(name);
//        String n = name.replaceAll("o", "");
//        String[] arr = name.split(" ");
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(n);
//        System.out.println(buffer.reverse());
//
//        System.out.println(name.hashCode());
        System.out.println(buffer.capacity());
    }
}
