package Kunal.Heaps.Questions;

import Kunal.Trees.BFS;

import java.util.PriorityQueue;

public class KthSmallestBST extends BFS{

    public int kthSmallest(TreeNode node, int k){
        // there are two methods to solve this problem first is create minHeap and all the element of the BST into that heap
        // and run a for loop from 0 to k to find the kth element

        int ans = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        helper(node, minHeap);

        // now run a for loop from 0 till k
        for(int i = 0; i < k; i++){
            ans = minHeap.remove();
        }
        return ans;
    }

    private void helper(TreeNode node, PriorityQueue<Integer> minHeap){
        if(node == null){
            return;
        }

        // now we will perform the inorder traversal and all the element into the minHeap

        helper(node.left, minHeap);
        // now here I have to add my current element into the minHeap
        minHeap.offer(node.val);
        helper(node.right, minHeap);
    }
}
