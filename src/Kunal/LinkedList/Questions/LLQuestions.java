package Kunal.LinkedList.Questions;

public class LLQuestions {
    private Node head;
    private Node tail;
    private int size;
    LLQuestions(){
        this.size = 0;
    }


    public void insertRec(int value, int index){
        head = rec(value, index, head);
    }

    private Node rec(int value, int index, Node current){
        if(index == 0){
            Node node = new Node(value, current);
            size++;
            return node;
        }

        current.next = rec(value, index - 1, current.next);
        return current;
    }
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int value){
        if(head == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;

        size++;
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public void removeDuplicates(){
        if(head == null){
            return;
        }

        Node current = head;
        while(current.next != null){
            if(current.value == current.next.value){
                current.next = current.next.next;
                size--;
            }else{
//                System.out.print(current.value + " -> ");
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/description/
    public static LLQuestions merge(LLQuestions head1, LLQuestions head2){
        Node f = head1.head;
        Node s = head2.head;

        LLQuestions ans = new LLQuestions();

        while(f != null && s != null){
            if(f.value <= s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        // in the end if any one of LL is not empty then all the nodes of that LL will be added to the ans LL.
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    // cycle detection
    public boolean detectCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null &&  fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    // length of the cycle
    public int findLength(Node head){
        Node slow = head;
        Node fast = head;
        int length = 0;
        while(fast != null &&  fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                do{
                    slow = slow.next;
                    length++;
                }while(slow != fast);
            }
        }

        return length;
    }


    // find the starting point of the cycle
    // https://leetcode.com/problems/linked-list-cycle-ii/
    public Node findTheStartOfCycle(Node head){
        Node slow = head;
        Node fast = head;
        int length = 0;
        while(fast != null &&  fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                do{
                    slow = slow.next;
                    length++;
                }while(slow != fast);
                break;
            }
        }

        if(length == 0){
            return null;
        }
        Node start = head;
        Node end = head;
        for(int i = 0; i < length; i++){
            end = end.next;
        }
        while(start != end){
            start = start.next;
            end = end.next;
        }
        return start;
    }



    // Happy number
    // https://leetcode.com/problems/happy-number/
    public static boolean findHappyOrNot(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while (slow != fast);
        return slow == 1;
    }

    public static int findSquare(int n){
        if(n == 0){
            return 0;
        }
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }


    // this is using merge sort
    public Node sortList(Node head){
        if(head != null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return mergeList(left, right);
    }

    private Node mergeList(Node left, Node right){
        Node dummyHead = new Node();
        Node tail = dummyHead;
        while(left != null && right != null){
            if(left.value > right.value){
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }else{
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }
        }

        if(left != null){
            tail.next = left;
        }else{
            tail.next = right;
        }
        return dummyHead.next;
    }

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    // reversing LL
    public void reverseRec(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverseRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }


    // Inplace reversal of LL
    public Node reverse(Node head){
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    // reversal of LL, between some range of left and right
    public Node reverseBetweenRange(Node head, int left, int right){
        if(head == null || left == right){
            return head;
        }

        // now I have to traverse till l - 1 while taking two pointer for the connection of the nodes which is going to
        // take place at the end of the reversal of the ranged part.
        Node prev = null;
        Node current = head;
        for(int i = 0; current != null && i < left - 1; i++){
            prev = current;
            current = current.next;
        }

        // now my current will be at the end of the reverse range LL and prev will be at the start of the new LL
        Node start = prev;
        Node newEnd = current;
        Node next = current.next;

        // now the actual reversal part will be going to take place
        for(int i = 0; current != null && i < right - left + 1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        // now the reversal of the LL has been done. now the actual part which is connecting the reverse part to the start and the end + 1 node of the range
        // first I have to check whether my LL is starting from the actual range
        if(start != null){
            // if not then start.next will be my prev, which will be pointing start of the reverse LL.
            start.next = prev;
        }else{
            // else head will be the prev
            head = prev;
        }

        // now here I have to make current which will the node which is present out of the range, I have to connect my
        // new end to that node
        newEnd.next = current;
        return head;
    }


    // check whether LL is palindrome or not

    public boolean isPalindrome(Node head){
        // to solve this problem I have to first get the middle node of the LL, and then Reverse from that middle element
        Node mid = getMid(head);
        Node reverseHead = reverse(mid);
        Node reReverseHead = reverseHead;

        while(reverseHead != null && reverseHead.next != null){
            if(head.value != reverseHead.value){
                break;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }

        reverse(reReverseHead);

        return head == null || reverseHead == null;
    }

    // reorder LL
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find the middle node
        Node mid = getMid(head);
        Node head2 = mid.next;
        mid.next = null;  // Split the list into two halves

        // Reverse the second half
        head2 = reverse(head2);

        // Merge the two halves
        Node head1 = head;
        while (head1 != null && head2 != null) {
            Node temp1 = head1.next;
            Node temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }

    // rotate list
    // https://leetcode.com/problems/rotate-list/description/

    public Node rotate(int k, Node head){
        if(k < 0 || head == null || head.next == null){
            return head;
        }

        // now the actual part begins.

        int length = 1;
        Node last = head;
        // first I have to find the last node of the LL
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotation = k % length;
        int skip = length - rotation;
        Node newLast = head;
        for(int i = 0; last != null && i < skip - 1; i++){
            newLast = newLast.next;
        }

        head = newLast.next;
        last.next = null;
        return head;
    }
    public void display(){
        Node temp = head;
        Node last;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node{
        int value;
        Node next;

        Node(){}

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
