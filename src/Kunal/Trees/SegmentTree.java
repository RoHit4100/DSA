package Kunal.Trees;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {30, 8, 9, 11, 12, 14, 20};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();

        System.out.println(tree.query(1, 5));
    }

    class Node{
        int startInterval;
        int endInterval;
        int value;
        Node left;
        Node right;

        Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }


    private Node root;

    SegmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    // O(n) to create a tree
    Node constructTree(int[] arr, int start, int end){
        Node node = new Node(start, end);
        if(start == end){
            node.value  = arr[start];
            return node;
        }
        // now I have to assign the value of this node for this case lets just consider query is sum here;
        int mid = (start + end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.value = node.left.value + node.right.value;
        return node;
    }

    void display(){
        display(this.root);
    }

    private void display(Node node){
        String str = "";

        // this is for left child
        if(node.left != null){
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data is: " + node.left.value + " <= ";
        }else {
            str = str + "left child is null " + " <= ";
        }

        // this is for current node
        str = str + "[" + node.startInterval + "-" + node.endInterval + "] and data is: " + node.value + " => ";


        // this is for right child
        if(node.right != null){
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data is: " + node.right.value;
        }else {
            str = str + " right child is null";
        }

        System.out.println(str);
        System.out.println();

        // now it's time to go deep into the tree by using recursion
        if(node.left != null){
            display(node.left);
        }
        if(node.right != null){
            display(node.right);
        }
    }


    // now for the important part of the segment tree
    int query(int sq, int eq){
        return query(this.root, sq, eq);
    }

    private int query(Node node, int sqi, int eqi){
        if(node.startInterval >= sqi && node.endInterval <= eqi){
            // In this case I know that my answer is in between this range
            // so just return the value present at that point
            return node.value;
        }else if(node.endInterval < sqi || node.startInterval > eqi){
            return 0;
        }else{
            return this.query(node.left, sqi, eqi) + this.query(node.right, sqi, eqi);
        }
    }


    void update(int index, int value){
         this.root.value = this.update(this.root, index, value);
    }
    private int update(Node node, int index, int value){
        // to update check first index lies into the interval or not
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.value = value;
                return node.value;
            }
        }else{
            int left = update(node.left, index, value);
            int right = update(node.right, index, value);
            node.value = left + right;
            return node.value;
        }

        return node.value;
    }
}
