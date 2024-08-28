package Strivers.LinkList.Questions.Easy;

import Strivers.LinkList.CodingNinja;

public class AddOneTwoLL extends CodingNinja {
    public Node addOne(Node head) {
        // code here.
        if(head == null){
            return null;
        }

        // now we have to add the 1 to the linkList
        // 4-5-6, then 456+1 = 457, will be the answer

        // for the first we have to reverse the given LL
        Node reverseHead = reverse(head);

        // now add the one to each and every node
        int carry = 1;
        Node temp = reverseHead;

        while (temp != null){
            int result = temp.data + carry;
            if(result >= 10){
                temp.data = 0;
            }else{
                temp.data = result;
                carry = 0;
                break;
            }
            temp = temp.next;
        }
        if(carry == 1){
            Node node = new Node(1);
            reverse(reverseHead);
            node.next = head;
            head = node;
            return head;
        }

        return reverse(reverseHead);
    }

    public Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = head.next;

        while (current != null){
            current.next = prev;

            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }


    // optimal approach will be using recursion to solve this problem
    public Node addOne1(Node head) {
        // code here.
        if (head == null) {
            return null;
        }

        // to solve this problem we will use the recursion
        int carry = helper(head);
        if (carry == 1){
            Node node = new Node(1);
            node.next = head;
            head = node;
            return head;
        }
        return head;
    }

    public int helper(Node head){
        if(head == null){
            return 1;
        }

        int carry = helper(head.next);
        if(carry == 1){
            int result = head.data + 1;
            if(result >= 10){
                head.data = 0;
                return 1;
            }
            return 0;
        }
        return carry;
    }
}
