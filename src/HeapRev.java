import java.util.ArrayList;
import java.util.List;

public class HeapRev<T extends Comparable<T>> {
    ArrayList<T> list;

    HeapRev() {
        // whenever object of HeapRev is going to create we will just instantiate the list
        list = new ArrayList<>();
    }

    // now for our convenience just create a swap function which just swap the two given indexes
    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    // now create a function to get the parent and left and right location of a node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // now create a function which return the left child of a particular node
    private int left(int index) {
        return index * 2 + 1;
    }

    // create the function which just return the right child of the particular given node
    private int right(int index) {
        return index * 2 + 2;
    }
    // now create the insert function
    public void insert(T value) {
        // first insert the element at the last index of the list
        list.add(value);

        // then call the up heap function which basically checks whether the function is smaller than its parent,
        // and if the condition is true then just call the swap function
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {
        if (index == 0) {
            return;
        }

        // now get the parent location
        int p = parent(index);
        T parent = list.get(p);
        // now check whether parent is greater than the current index node
        if (list.get(index).compareTo(parent) < 0) {
            // if this is true then swap with its parent
            swap(index, p);
            // reassign the index to parent
            index = p;
            // call the upHeap function with updated index
            upHeap(index);
        }
    }

    // function to remove the first node of the tree
    // here we have to make a downHeap function
    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is already empty");
        }
        // first remove the element present at the first index of the list
        T removed = list.get(0);
        // after removing the first element check whether the list has become empty or not
        if (list.size() > 1) {
            // swap set the last element of the list as first element
            list.set(0, list.remove(list.size() - 1));
            // now call the downHeap function
            downHeap(0);
        } else {
            list.remove(0);
        }
        return removed;
    }

    private void downHeap(int index) {
        // Ensure the list is not empty
        if (list.isEmpty()) {
            return;
        }

        // get the right and left element of the first index
        int right = right(index), left = left(index);
        // now to compare with left and right maintain a min index
        int min = index;

        // first we have to check whether my left and right are less than my list size if not then we can perform the downHeap
        // check whether my min is actually min than left element if not then just update the min as left
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        // perform the same operation with right child
        // update right if right element is minimum than current min
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        // in the end if any on of the condition is triggered then min will change, check if min is updated or not
        // if not updated then just return;
        if (min == index) {
            return;
        }

        // if not then swap
        swap(min, index);
        // call this function again
        downHeap(min);
    }

    // now to perform heap sort we know that because of heap property all the parents will be less than its children
    // so to implement this just remove each element until list becomes empty
    public List<T> heapSort() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is already empty");
        }

        List<T> sortedList = new ArrayList<>();
        while (!list.isEmpty()) {
            sortedList.add(this.remove());
        }
        return sortedList;
    }

    public static void main(String[] args) throws Exception {
        HeapRev<Integer> heap = new HeapRev<>();

        for (int i = 19; i > 5; i--) {
            heap.insert(i);
        }

        System.out.println(heap.remove());
        System.out.println(heap.heapSort());
    }
}