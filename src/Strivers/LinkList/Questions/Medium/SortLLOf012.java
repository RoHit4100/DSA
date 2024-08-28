package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import javax.swing.plaf.IconUIResource;

public class SortLLOf012 extends CodingNinja {
    // this will be the brute force in which we will replace the LL data
    static Node segregate(Node head) {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }

        // now traverse through LL and count the no. of 0,1,2
        int ones = 0;
        int twos = 0;
        int zeros = 0;

        Node temp = head;
        while (temp != null){
            if(temp.data == 0){
                zeros++;
            }else if(temp.data == 1){
                ones++;
            }else{
                twos++;
            }
            temp = temp.next;
        }


        // now we have to count, now replace the data present in the LL
        temp = head;
        while (temp != null){
            if(zeros > 0){
                zeros--;
                temp.data = 0;
            }else if(ones > 0){
                ones--;
                temp.data = 1;
            }else{
                twos--;
                temp.data = 2;
            }
            temp = temp.next;
        }

        return head;
    }


    // another method will be adding particular node in that particular LL
    public static Node sortList(Node head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }

        // create three dummy heads
        Node zerosHead = new Node(0), zeros = zerosHead;
        Node onesHead = new Node(1), ones = onesHead;
        Node twosHead = new Node(2), twos = twosHead;

        Node temp = head;
        while (temp != null){
            if(temp.data == 0){
                zeros.next = temp;
                zeros = zeros.next;
            }else if(temp.data == 1){
                ones.next = temp;
                ones = ones.next;
            }else{
                twos.next = temp;
                twos = twos.next;
            }
            temp = temp.next;
        }

        // now connect all this node with each other
        zeros.next = onesHead.next != null ? onesHead.next: twosHead.next;
        ones.next = twosHead.next;
        twos.next = null;
        return zerosHead.next;
    }
}
