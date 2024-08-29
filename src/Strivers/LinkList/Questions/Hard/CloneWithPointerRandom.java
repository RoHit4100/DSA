package Strivers.LinkList.Questions.Hard;

import java.util.HashMap;

public class CloneWithPointerRandom {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // first approach is using the HashMap.
    // the intuition is creating nodes and storing them into hashmap
    public Node createRandomList(Node head){
        if(head == null){
            return null;
        }
        // in this problem we have to create each node and store that node with cloned node
        HashMap<Node, Node> map = new HashMap<>();

        // first step is traversing through LL and creating deep copy of each node val
        Node temp = head;
        while (temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        // now connect every node with its random and next pointer
        temp = head;
        while (temp != null){
            Node current = map.get(temp);
            current.next = map.get(temp.next); // get the temp.next
            current.random = map.get(temp.random); // get the temp.random, we cant use current here, as current's random is null at this point

            // move temp by one step ahead
            temp = temp.next;
        }

        return map.get(head);
    }


    // optimal solution will be not using HashMap
    public Node copyRandomList(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        // FIRST CREATE COPY NODES AND ATTACH THEM IN BETWEEN TWO NODES
        createAndAttachCopy(head);
        // NOW CONNECT COPY NODES TO THEIR RANDOM LINKS
        connectRandomPointer(head);
        // NOW RETURN THE DISCONNECTED CLONE LL
        return disconnectCloneFromOriginal(head);
    }
    private void createAndAttachCopy(Node head){
        // this is the step one, and here we are going to create and attach the nodes in between two nodes
        Node temp = head;
        while (temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        // now copy of each node will be inserted in between this nodes
    }

    private void connectRandomPointer(Node head){
        Node temp = head;
        while (temp != null){
            Node copyNode = temp.next; // because of previous node
            if(temp.random != null) {
                copyNode.random = temp.random.next; // here the copy of the temps random will be store, this will connect to the random
            }else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

   private Node disconnectCloneFromOriginal(Node head){
        // first create dummy Node to link with the actual cloned node
       Node dummyHead = new Node(-1);
       Node result = dummyHead;

       Node temp = head;
       while (temp != null){
           result.next = temp.next; // because this is the copy

           temp.next = temp.next.next; // this will connect the original link

           result = result.next; // move one step ahead;
           temp = temp.next; // move one step ahead;
       }

       return dummyHead.next;
   }
}
