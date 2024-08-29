package Strivers.LinkList.Questions.Hard;

import Strivers.LinkList.CodingNinja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenSinglyLL {
    private class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }


    // brute fore solution will be adding every item into list and then sorting and creating a LL
    // this will take lot of space and time complexity
    Node flattenBF(Node root) {
        // code here
        if(root == null){
            return null;
        }

        // create a list, which will store all the elements
        List<Integer> list = new ArrayList<>();

        // now store all the elements into the list
        store(root, list);

        // now we have all the elements store into the list
        // sort list now
        Collections.sort(list);

        // now convert this list into flatter list
        return convert(list);
    }

    private Node convert(List<Integer> list){
        Node dummyHead = new Node(list.get(0)); // first node is created start traversing from second node
        Node temp = dummyHead;
        for(int i = 1; i < list.size(); i++){
            temp.bottom = new Node(list.get(i));
            temp = temp.bottom;
        }
        return dummyHead;
    }

    private void store(Node root, List<Integer> list){
        // traverse through LL

        while (root != null){ // this loop is used for going right side
            Node temp = root;
            while (temp != null){ // this loop is used for going bottom
                list.add(temp.data);
                temp = temp.bottom; // this will move one step down
            }
            root = root.next; // this will move one step to the right
        }
    }


    // this is the optimal using recursion and using the fact that given list is sorted
    Node flatten(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // now we have to first get to the last LL, using recursion
        Node last = flatten(head.next); // this will return the head of last node
        // head will the current node
        return merge(head, last);
    }

    Node merge(Node first, Node second){
        // now we have to merge both of the LL, while comparing, its same as merging two lists
        // take dummy head to return head at the end
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;
        while (first != null && second != null){
            if(first.data < second.data){
                temp.bottom = first;
                temp = first;
                first = first.bottom;
            }else{
                temp.bottom = second;
                temp = second;
                second = second.bottom;
            }
            // if any of the next node has next make it null
            temp.next = null;
        }
        // now in the end check if any of the node has remaining elements, add those elements into this list
        if(first != null){
            temp.bottom = first;
        }
        if(second != null){
            temp.bottom = second;
        }

        // check if dummy head bottom is null or not, if not null then break
        if(dummyHead.bottom != null){
            dummyHead.bottom.next = null;
        }

        return dummyHead.bottom;
    }
}
