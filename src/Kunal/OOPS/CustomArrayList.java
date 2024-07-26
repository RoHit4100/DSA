package Kunal.OOPS;

import java.util.ArrayList;

public class CustomArrayList<T> {
    private Object[] arr;
    private int size = 0;
    private final int DEFAULT_SIZE = 10;

    CustomArrayList(){
        this.arr = new Object[DEFAULT_SIZE];
    }

    public void add(T element){
        if(isFull()){
            Object[] temp = new Object[arr.length * 2];
            for(int i = 0; i < arr.length; i++){
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[size++] = element;
    }

    private boolean isFull(){
        return size == arr.length;
    }

    public void set(int index, T value){
        arr[index] = value;
    }
    public T remove(){
        if(isEmpty()){
            return null;
        }
        return (T)arr[--size];
    }
    public int getSize(){
        return size;
    }
    public T getNumAtIndex(int index){
        if(index >= size){
            return null;
        }
        return (T)arr[index];
    }
    public boolean contains(T value){
        for(Object element: arr){
            if(element == value){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Array is empty");
            return;
        }

        System.out.print("[");
        for(int i = 0; i < size; i++){
            if(i == size - 1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + ", ");
            }
        }

        System.out.print("]");
        System.out.println();
    }
}

class Run{
    public static void main(String[] args) {
        CustomArrayList<Integer> ls = new CustomArrayList<>();
        ls.add(12);
        ls.add(23);
        ls.add(33);
        for(int i = 1; i < 10; i++){
            ls.add(i * 2);
        }
        ls.print();
        System.out.println(ls.getSize());
        System.out.println(ls.remove());
        ls.print();
        int n = ls.getNumAtIndex(2);
        System.out.println(n);


        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("rohit");
        list.print();
    }
}

