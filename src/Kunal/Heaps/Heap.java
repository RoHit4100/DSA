package Kunal.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap <T extends Comparable> {
    List<T> heap;
    public Heap(){
        heap = new ArrayList<>();
    }

    public void swap(int first, int second){
        T temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }

    private int parent(int index){
        return (index + 1) / 2;
    }

    private int left(int index){
        return index * 2 + 1;
    }

    private int right(int index){
        return index * 2 + 2;
    }

    public void insert(T value){
        // first add the value into the heap
        heap.add(value);
        // call the upHeap function by passing the last index, as we have to insert element by comparing to its parent node
        upHeap(heap.size() - 1);
    }

    private void upHeap(int index){
        if(index == 0){
            return;
        }

        // now get the parent of that index, and check if that element is smaller than its parent
        int p = parent(index);

        // check now
        if(heap.get(index).compareTo(heap.get(p)) < 0){
            swap(index, p);
            upHeap(p);
        }
    }

    private T remove() throws Exception{
        if(heap.isEmpty()){
            throw new Exception("Removing from an empty heap");
        }

        T removed = heap.get(0);

        // now get the last element of the heap
        T last = heap.get(heap.size() - 1);
        if(!heap.isEmpty()){
            heap.set(0, last);
            downHeap(0);
        }
        return removed;
    }

    private void downHeap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < heap.size() && heap.get(min).compareTo(heap.get(left)) > 0) {
            min = left;
        }
        if (left < heap.size() && heap.get(min).compareTo(heap.get(right)) > 0) {
            min = right;
        }

        // now check if min is updated or not
        if(min != index){
            swap(min, index);
            downHeap(min);
        }
    }


    public List<T> heapSort() throws Exception{
        if(heap.isEmpty()){
            throw new Exception("Heap is empty");
        }

        List<T> list = new ArrayList<>();
        while (!heap.isEmpty()){
            list.add(this.remove());
        }
        return list;
    }

}
