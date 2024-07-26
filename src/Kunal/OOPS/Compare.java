package Kunal.OOPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Compare{
    public static void main(String[] args) {
        Student rohit = new Student(12, 59.1f);
        Student krunhna = new Student(13, 99.3f);
        Student yash = new Student(34, 89);
        Student[] ls = {rohit, krunhna, yash};
        Arrays.sort(ls);
        System.out.println(Arrays.toString(ls));
//        Arrays.sort(ls, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int)(o1.rollNo- o2.rollNo);
//            }
//        });
        // by using lambda functions.
        // lambda functions are inline functions which can be use to write minimal code.
        Arrays.sort(ls, (o1, o2) -> (int)(o1.rollNo - o2.rollNo));
        System.out.println(Arrays.toString(ls));


        if(rohit.compareTo(krunhna) < 0){
            System.out.println(rohit.compareTo(krunhna));
            System.out.println("jj");
        }
    }
}

class Student implements Comparable<Student>{
    int rollNo;
    float marks;

    Student(int rollNo, float marks){
        this.marks = marks;
        this.rollNo = rollNo;
    }
    @Override
    // this method is used to compare two objects by using some value which is present in between them
    public int compareTo(Student other) {
        // here this function will return 3 values, which will be 0, -1, 1
        // 0 means both are equal
        // negative means other object is bigger
        // positive means the current or this object is bigger.
        return (int)(this.marks - other.marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }
}
