package Kunal.Hash;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UseHashing {
    public static void main(String[] args) {
        HashMap<String, Integer> db = new HashMap<>();

        db.put("Rohit", 78);
        db.put("shivam", 0);
        db.put("aman", 58);
        db.put("Krushna", 99);

        db.replace("shivam", 0, 55);
        System.out.println(db.get("shivam"));

        // iteration in hashmap
        for (Map.Entry<String, Integer> entity: db.entrySet()){
            System.out.println(entity.getKey() + " " +entity.getValue());
        }

        HashSet<Integer> set = new HashSet<>();

        set.add(45);
        set.add(5);
        set.add(45);
        set.add(45);
        System.out.println(set);
    }
}
