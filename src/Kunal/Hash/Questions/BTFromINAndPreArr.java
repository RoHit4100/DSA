package Kunal.Hash.Questions;

import Kunal.Trees.BFS;

import java.util.HashMap;
import java.util.Map;

public class BTFromINAndPreArr extends BFS {

    // create a BT using preOrder and inOrder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = inorder.length;

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(map, preorder, inorder, left, right - 1);
    }
    private int index = 0;
    private TreeNode buildTree(Map<Integer, Integer> inorderMap, int[] preorder, int[] inorder, int left, int right){
        if(left > right){
            return null;
        }

        int currentNode = preorder[index];
        TreeNode node = new TreeNode(currentNode);
        if(left == right){
            return node;
        }
        index++;
        Integer end = inorderMap.get(currentNode);
        node.left = buildTree(inorderMap, preorder, inorder, 0, end - 1);
        node.right = buildTree(inorderMap, preorder, inorder, end + 1, preorder.length);

        return node;
    }
}
