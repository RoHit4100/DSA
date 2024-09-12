package Strivers.BinaryTrees.Hard;
import Strivers.BinaryTrees.CodingNinjas;

import java.util.*;
public class VerticalTraversal extends CodingNinjas {
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            if(root == null) return ans;

            // we'll solve this question using dfs, or to be precised using preorder traversal
            // to store this answer we'll require map data structure which will has key as the col
            // and value as a list of array, in which array will have its row as first value and second value will be the node value
            // we use treeMap which will make sure that content is stored in ascending order
            Map<Integer, List<int[]>> map = new TreeMap<>();

            // now insert the values into the map, using preorder traversal
            preOrder(root, 0, 0, map);

            // now we have to retrieve those values, from the map, and insert into the answer for returning purpose
            for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()){
                // get the first list from the map, which will be in the sorted manner, -2,-1,0 etc....
                List<int[]> list = entry.getValue();

                // now sort the list based on the row wise, and if row are the same then sort on the basis of their values
                Collections.sort(list, (a, b) -> {
                    // first check for the row, which will be the element
                    if(a[0] == b[0]) return Integer.compare(a[1], b[1]); // this will sort on the basis of the values, when rows are equal
                    return Integer.compare(a[0], b[0]);
                });

                // now we have the sorted lists, we just have to insert the 1 index values into the ans

                // traverse through the list
                List<Integer> sortedList = new ArrayList<>();
                for(int[] arr: list){
                    sortedList.add(arr[1]);
                }

                ans.add(sortedList);
            }

            return ans;
        }

        private void preOrder(TreeNode root, int col, int row, Map<Integer, List<int[]>> map){
            if(root == null) return;

            // first get the list of array which is assign to current col
            List<int[]> list = map.getOrDefault(col, new ArrayList<>()); // this will retrieve the list, if not present previously then create new list
            // now add the current row and current node's value into the list, and insert back to map
            list.add(new int[]{row, root.data});
            map.put(col, list); // update with newly inserted array into the list

            // now call this function for rest of the nodes
            preOrder(root.left, col - 1, row + 1, map); // when going into the left, col will be reduced by 1

            preOrder(root.right, col + 1, row + 1, map);
        }
    }


    // coding ninjas solution
    public static List<Integer> verticalOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        // we'll solve this question using dfs, or to be precised using preorder traversal
        // to store this answer we'll require map data structure which will has key as the col
        // and value as a list of array, in which array will have its row as first value and second value will be the node value
        // we use treeMap which will make sure that content is stored in ascending order
        Map<Integer, List<int[]>> map = new TreeMap<>();
        // now insert the values into the map, using preorder traversal
        preOrder(root, 0, 0, map);

        // now we have to retrieve those values, from the map, and insert into the answer for returning purpose
        for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()){
            // get the first list from the map, which will be in the sorted manner, -2,-1,0 etc....
            List<int[]> list = entry.getValue();

            // now sort the list based on the row wise, and if row are the same then sort on the basis of their values
            Collections.sort(list, (a, b) -> {
                // first check for the row, which will be the element
                if(a[0] == b[0]) return Integer.compare(a[1], b[1]); // this will sort on the basis of the values, when rows are equal
                return Integer.compare(a[0], b[0]);
            });

            // now we have the sorted lists, we just have to insert the 1 index values into the ans

            // traverse through the list

            for(int[] arr: list){
                ans.add(arr[1]);
            }
        }

        return ans;
    }

    private static void preOrder(TreeNode root, int col, int row, Map<Integer, List<int[]>> map){
        if(root == null) return;

        // first get the list of array which is assign to current col
        List<int[]> list = map.getOrDefault(col, new ArrayList<>()); // this will retrieve the list, if not present previously then create new list
        // now add the current row and current node's value into the list, and insert back to map
        list.add(new int[]{row, root.data});
        map.put(col, list); // update with newly inserted array into the list

        // now call this function for rest of the nodes
        preOrder(root.left, col - 1, row + 1, map); // when going into the left, col will be reduced by 1

        preOrder(root.right, col + 1, row + 1, map);
    }
}
