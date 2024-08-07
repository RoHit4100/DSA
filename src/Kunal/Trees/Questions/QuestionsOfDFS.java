package Kunal.Trees.Questions;

import Kunal.Strings.BInteger;
import Kunal.Trees.BFS;
import com.sun.source.tree.Tree;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class QuestionsOfDFS extends BFS {
    // https://leetcode.com/problems/diameter-of-binary-tree/
    // post order
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // to calculate the maximum diameter we have to take one global variable
        // create a height function which calculate the height of that node
        height(root);
        // return the diameter - 1
        return diameter;
    }

    private int height(TreeNode node){
        // if node is null just return height as 0
        if(node == null){
            return 0;
        }

        // now get the left and right height of its children nodes
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // the diameter for that particular node will be leftHeight + rightHeight + 1
        int dia = leftHeight + rightHeight;
        // now take the max diameter present at any moment, by comparing with current nodes diameter
        diameter = Math.max(dia, diameter);
        // height for any node will be max of right and left node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // https://leetcode.com/problems/invert-binary-tree/
    // post order - where I am working on the parent after visiting childrens

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node){
        if(node == null){
            return;
        }
        // first get to the left node
        invert(node.left);
        // second get to the right node
        invert(node.right);
        // swap the right and left nodes
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }


    // flatten binary tree
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        // now we cant change the root, so just simply take another pointer to traverse
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }


    // https://leetcode.com/problems/validate-binary-search-tree/

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        if(left != null && right != null){
            return root;
        }

        return left == null ? right: left;
    }


    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    int index = 0;
    int element = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return element;
    }

    private void helper(TreeNode node, int k){
        if(node == null){
            return;
        }

        helper(node.left, k);
        index++;
        if(index == k){
            element = node.val;
        }
        helper(node.right, k);
    }

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }

        // now here we know that our root will be the first index of the preorder array
        int rootValue = preorder[0];
        // now we have to find the index value of the root in the inorder array
        int index = 0;

        // check with for loop and find the index
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                index = i;
                break;
            }
        }

        // once we get the index then just create the root node with root value
        TreeNode node = new TreeNode(rootValue);
        // now we have to add left and right of node according to the index
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index + 1));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Serializes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializeCode = new StringBuilder();
        helperSerialize(root, serializeCode);
        return serializeCode.toString();
    }

    private void helperSerialize(TreeNode node, StringBuilder code) {
        if (node == null) {
            code.append("n ");
            return;
        }

        code.append(node.val).append(" ");
        helperSerialize(node.left, code);
        helperSerialize(node.right, code);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(" ");
        return helperDeserialize(arr);
    }

    private int i; // Move the index outside the method to be class-level

    private TreeNode helperDeserialize(String[] arr) {
        if (i >= arr.length || arr[i].equals("n")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left = helperDeserialize(arr);
        root.right = helperDeserialize(arr);

        return root;
    }

    // https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,  targetSum - root.val);
    }


    // https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {
        return helper1(root, 0);
    }

    private int helper1(TreeNode node, int sum){
        if(node == null){
            return 0;
        }

        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
        return helper1(node.left, sum) + helper1(node.right, sum);
    }

    // max sum path leetcode hard

    int maxPathSum = Integer.MIN_VALUE;
    public int maxPath(TreeNode root){
        findMaxPath(root);
        return maxPathSum;
    }

    private int findMaxPath(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = findMaxPath(node.left);
        int right = findMaxPath(node.right);

        int sum = left + right + node.val;
        maxPathSum = Math.max(maxPathSum, sum);
        return Math.max(left, right) + node.val;
    }


    // https://leetcode.com/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        findPaths(root, new StringBuilder(), paths);
        return paths;
    }

    private void findPaths(TreeNode node, StringBuilder path, List<String> paths) {
        if (node == null) {
            return;
        }
        int length = path.length(); // Remember the length of the path before appending
        path.append(node.val);
        if (node.left == null && node.right == null) { // If it's a leaf node
            paths.add(path.toString());
        } else {
            path.append("->");
            findPaths(node.left, path, paths);
            findPaths(node.right, path, paths);
        }
        path.setLength(length); // Reset the path to its original length
    }

    // find if Path exist in the binary tree or not
    public boolean check(TreeNode root, List<Integer> list){
        if(root == null || list.isEmpty()){
            return false;
        }

        return find(root, list, 0);
    }

    private boolean find(TreeNode node, List<Integer> list, int index){
        if(node == null  ){
            return false;
        }
        if(index >= list.size() || node.val != list.get(index)){
            return false;
        }
        if(node.left == null && node.right == null && index == list.size() - 1){
            return true;
        }
        return find(node.left, list, index + 1) || find(node.right, list, index + 1);
    }


    // find how many paths can make a sum k, path can exist anywhere in the node.
    public int findPaths(TreeNode root, int sum){
        if(root == null){
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        return returnCount(root, list, sum);
    }


    private int returnCount(TreeNode node, List<Integer> paths, int sum){
        if(node == null){
            return 0;
        }

        // this list will maintain the nodes which I have travel till that point
        paths.add(node.val);
        // this count variable will maintain the ans till that point, this will add the paths from the right and paths from left
        int count = 0;
        int s = 0;


        // this will just iterate on my list from the end, as start of the list is already checked
        ListIterator<Integer> itr = paths.listIterator(paths.size());
        // iterator requires the while loop to iterate
        // it will run until list, itr has something previous
        while (itr.hasPrevious()){
            // get the previous element in each iteration and just add to the s variable
            s += itr.previous();
            // check whether s == sum which is given sum and increase the count pointer.
            if(s == sum){
                count++;
            }
        }

        // this variable will basically store all the answers which are return from the left and right
        count += returnCount(node.left, paths, sum) + returnCount(node.right, paths, sum);

        // but before returning the count I have to backtrack
        // this line will just simply remove the last element of the list.
        paths.remove(paths.size() - 1);

        // in the end just return the count.
        return count;
    }
}
