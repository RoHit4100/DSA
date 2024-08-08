package Kunal.Hash;

import java.util.HashMap;
import java.util.HashSet;

public class UseHashing {
    public static void main(String[] args) {
        HashMap<String, Integer> db = new HashMap<>();

        db.put("Rohit", 78);
        db.put("shivam", 0);
        db.put("aman", 58);
        db.put("Krushna", 99);

        db.replace("shivam", 0, 55);
        System.out.println(db.get("shivam"));


        HashSet<Integer> set = new HashSet<>();

        set.add(45);
        set.add(5);
        set.add(45);
        set.add(45);
        System.out.println(set);
    }
}
