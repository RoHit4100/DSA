package Strivers.BinaryTrees.Hard;

import Strivers.BinaryTrees.CodingNinjas;
import java.util.*;
public class BTFromPostAndInorder extends CodingNinjas {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // first insert all the values into the inorder map
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        int start = 0;
        int end = inorder.length - 1;
        return build(map, postorder, start, end, new int[]{end}); // index will start from the end of the post order
    }

    private TreeNode build(Map<Integer, Integer> inOrder, int[] postOrder, int start, int end, int[] index){
        if(start > end){ // return null if start becomes greater than the end
            return null;
        }

        // first get the current element from the preOrder
        int currentElement = postOrder[index[0]--];
        // now create the node from the current node
        TreeNode node = new TreeNode(currentElement);
        // now get the index from the inOrder map
        Integer inOrderIndex = inOrder.get(currentElement);
        // now first call for the right and then for left
        node.right = build(inOrder, postOrder, inOrderIndex + 1, end, index);
        node.left = build(inOrder, postOrder, start, inOrderIndex - 1, index);

        // in the end return the node
        return node;
    }
}
