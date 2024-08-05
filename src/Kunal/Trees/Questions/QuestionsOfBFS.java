package Kunal.Trees.Questions;

import Kunal.Trees.BFS;
import com.sun.source.tree.Tree;

import java.awt.color.ICC_ColorSpace;
import java.util.*;

public class QuestionsOfBFS extends BFS {

    // https://leetcode.com/problems/average-of-levels-in-binary-tree
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            double sum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                // now add the childrens of currentNode
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            double averageOfLevel = sum / levelSize;
            result.add(averageOfLevel);
        }

        return result;
    }

    // https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

    public TreeNode inorderSuccessor(TreeNode root,TreeNode node){
        //add code here.
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // now add all the nodes by using inorder traversal
        inOrder(root, queue);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode == node){
                return queue.poll();
            }
        }
        return null;
    }

    void inOrder(TreeNode node, Queue<TreeNode> queue){
        if(node == null){
            return;
        }

        inOrder(node.left, queue);
        queue.offer(node);
        inOrder(node.right, queue);
    }



    // find level order successor of a node
    public TreeNode successor(TreeNode root, int key){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
            if(currentNode.val == key){
                return queue.poll();
            }
        }
        return null;
    }


    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    public List<List<Integer>> zigZagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        int level = 1;
        while (!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            if(level % 2 != 0){
                for(int i = 0; i < levelSize; i++){
                    TreeNode currentNode = deque.getFirst();
                    levelList.add(currentNode.val);
                    if (currentNode.left != null){
                        deque.offer(currentNode.left);
                    }

                    if(currentNode.right != null){
                        deque.offer(currentNode.right);
                    }
                }
            }else{
                for(int i = 0; i < levelSize; i++){
                    TreeNode currentNode = deque.pollLast();
                    levelList.add(currentNode.val);
                    if (currentNode.right != null){
                        deque.offerFirst(currentNode.right);
                    }

                    if(currentNode.left != null){
                        deque.offerFirst(currentNode.left);
                    }
                }
            }
            level++;
            result.add(levelList);
        }

        return result;
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, levelList);
        }
        return result;
    }


    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public TreeNode connect(TreeNode root) {
        if(root == null){
            return null;
        }

        // let's travel from left side till we reach null
        TreeNode leftMostNode = root;

        while(leftMostNode.left != null){
            // now consider the current node as left most node and start connecting its
            // childrens to their siblings
            TreeNode currentNode = leftMostNode;

            while(currentNode != null){
                currentNode.left.next = currentNode.right;
                if(currentNode.next != null){
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }

            leftMostNode = leftMostNode.left;
        }

        return root;
    }



   // https://leetcode.com/problems/binary-tree-right-side-view/

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();
                if(i == size - 1){
                    result.add(currentNode.val);
                }

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    // https://leetcode.com/problems/cousins-in-binary-tree/description/

    public boolean isCousins(TreeNode root, int x, int y){
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        if(xx == null || yy == null){
            return false;
        }
        // once u have found the node check whether they belong to the same level, and they are not siblings.
        boolean belongsToSameLevel = level(root, xx, 0) == level(root, yy, 0);
        return belongsToSameLevel && !isSiblings(root, xx, yy);
    }

    private boolean isSiblings(TreeNode node, TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }

        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSiblings(node.left, x, y) || isSiblings(node.right, x, y)
        );
    }

    private int level(TreeNode node, TreeNode target, int level){
         if(node == null){
             return 0;
         }
         if(node == target){
            return level;
         }

         int l = level(node.left, target, level + 1);
         if(l != 0){
             return l;
         }
         return level(node.right, target, level + 1);
    }

    private TreeNode findNode(TreeNode node, int value){
        if(node == null){
            return null;
        }

        if(node.val == value){
            return node;
        }
        /* now call recursively to find the node on the left side. */
        TreeNode left = findNode(node.left, value);
        if(left != null){
            return left;
        }
        // if node is not present on the left side then node has to present on the right side.
        return findNode(node.right, value);
    }


    // https://leetcode.com/problems/symmetric-tree/description/

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        // first create queue, and for the fact we don't have to compare root node, as it is only one
        Queue<TreeNode> queue = new LinkedList<>();

        // now add the left and right of the root node
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            // now get the first two nodes from the queue
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right != null){
                return false;
            }

            if(left == null){
                continue;
            }

            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
