package Kunal.Hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap <K, V>{

    private ArrayList<LinkedList<Element>> list;
    private int size = 0;
    private float loadFactor = 0.5f;

    CustomHashMap(){
        list = new ArrayList<>();
        // initializing 10 LL
        for(int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        // first get the hash
        int hash = Math.abs(key.hashCode() % list.size());
        // extracting the LL present at that hashed index
        LinkedList<Element> elements = list.get(hash);
        // check for the each node of the element if it matches with the given key or not
        for(Element element: elements){
            if(element.key.equals(key)){
                // if matches then just add the value to it
                element.value = value;
                // and return from here
                return;
            }
        }


        // check the load factor
        // check the size of list is 50% filled then just create the new List with LL with doubling the previous size
        if((float) (size) / list.size() > loadFactor){
            reHash();
        }
        // if the place is empty just add new element in that place
        elements.add(new Element(key, value));
    }


    void reHash(){
        System.out.println("reHashing is processing");
        // assign the list to old variable
        ArrayList<LinkedList<Element>> old = list;
        list = new ArrayList<>();

        size = 0;

        // aad double LL in the newly created List
        for(int i = 0; i < old.size(); i++){
            list.add(new LinkedList<>());
        }

        // now add the elements present in the old list into the newly created list
        for(LinkedList<Element> entries: old){
            for(Element entry: entries){
                // it will insert the keys and values into newly created list
                put(entry.key, entry.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        // get ths LL present at that hashed index
        LinkedList<Element> elementsList = list.get(hash);

        // check for every element present in that LL
        for(Element element: elementsList){
            // if any element has the same key then just return that key
            if(element.key.equals(key)){
                return element.value;
            }
        }
        // otherwise return null
        return null;
    }


    public boolean contains(K key){
        // it will return false if returned value is null
        return get(key) != null;
    }
    class Element{
        K key;
        V value;

        Element(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
