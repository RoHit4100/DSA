package Strivers.BinaryTrees.Hard;
import Strivers.BinaryTrees.CodingNinjas;

import java.util.*;
public class BTFromInorderAndPreOrder extends CodingNinjas {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // we will solve this question using recursion and hashMap
        Map<Integer, Integer> map = new HashMap<>();
        // this map will store the index and the values of inorder indexes
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i); // key will be element, and value will be its index
        }

        int left = 0;
        int right = preorder.length - 1;
        // from here we will call the recursive helper function
        return build(map, preorder, left, right);
    }


    int index = 0; // this will keep track of index for preOrder array
    private TreeNode build(Map<Integer, Integer> inOrder, int[] preOrder, int start, int end){
        if(start > end){
            return null;
        }


        // first get the root node from the preOrder map
        int currentElement = preOrder[index++]; // increase the index for next calls
        // create the node from currentElement
        TreeNode node = new TreeNode(currentElement);

        // now get the index for the current element from the inorder map, and choose the left and right
        Integer inOrderIndex = inOrder.get(currentElement);
        // now the left part will be from start to i - 1, and right part will be i + 1 to end
        node.left = build(inOrder, preOrder, start, inOrderIndex - 1);
        node.right = build(inOrder, preOrder, inOrderIndex + 1, end);

        // return the current node;
        return node;
    }
}
