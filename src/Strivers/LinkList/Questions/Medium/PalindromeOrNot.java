package Strivers.LinkList.Questions.Medium;

import Strivers.LinkList.CodingNinja;

import java.util.Stack;

public class PalindromeOrNot extends CodingNinja {
    // better solution will be using the array to store the LL
    public static int[] arr = new int[100000];
    static boolean isPalindromeBetter(Node head){
        if(head == null || head.next == null){
            return true;
        }

        // first insert all the values into the array
        int size = 0;
        Node node = head;
        while (node != null){
            arr[size++] = node.data;
            node = node.next;
        }


        // now traverse through array size / 2 times
        for(int i = 0; i < size / 2; i++){
            if(arr[i] != arr[size - i - 1]){
                return false;
            }
        }
        return true;
    }


    // brute force approach will be using stack
    static boolean checkPalindromeOrNot(Node head){
        if(head == null || head.next == null){
            return true;
        }


        // now store all the element into the stack;
        Stack<Integer> stack = new Stack<>();

        Node node = head;
        while (node != null){
            stack.push(node.data);
            node = node.next;
        }

        // now traverse again and check if elements are matched or not
        node = head;
        while (node != null){
            int last = stack.pop();
            if(node.data != last){
                return false;
            }
            node = node.next;
        }

        return true;
    }


    // optimal approach will be reversing the LL from middle and then checking by taking two pointer one is from start
    // and another is from middle.

    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        // first find the middle of the LL
        Node mid = getMid(head);

        // now reverse the LL from middle
        Node end = reverse(mid);
        // now check from start and end till end reaches to null
        while (end != null){
            if(head.data != end.data){
                return false;
            }
            end = end.next;
            head = head.next;
        }

        return true;
    }

    private Node reverse(Node node){
        Node current = node;
        Node prev = null;
        Node next = current.next;

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
    private Node getMid(Node node){
        // here we will use the fast and slow pointer method
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null){
            slow = slow.next; // move by one step
            fast = fast.next.next; // move by two steps
        }

        return slow; // this will be our middle
    }
}
