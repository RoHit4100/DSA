import Kunal.Trees.CreateTree;

import java.util.*;

public class RevisionForRecursion  {
    // how to convert a character into integer, for that we have to add that character with 0
    static List<String> permutations1(String p, String up){
        List<String> ls = new ArrayList<>();
        if(up.isEmpty()){
            ls.add(p);
            return ls;
        }
        // first we have to the character which is going to present the first index of the string
        char ch = up.charAt(0);
        // to find permutations the recursion calls are variable, means they depend on the length of the p string.
        // so we have to perform for loop until that string length
        for(int i = 0; i <= p.length(); i++){
            // here we have to change in between the positions of the process string
            // e.g. p == bc
            //      _bc, b_c, bc_ these are the 3 calls which recursion function will call,
            //      to get this positions we have to use substring method on the process string,
            //      so the first location is 0, till my i
            // 0,1
            // and so on...
            String s = p.substring(0, i);
            String e = p.substring(i, p.length());
            ls.addAll(permutations1(s + ch + e, up.substring(1)));
        }
        return ls;
    }
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        // first we have to the character which is going to present the first index of the string
        char ch = up.charAt(0);
        // to find permutations the recursion calls are variable, means they depend on the length of the p string.
        // so we have to perform for loop until that string length
        for(int i = 0; i <= p.length(); i++){
            // here we have to change in between the positions of the process string
            // e.g. p == bc
            //      _bc, b_c, bc_ these are the 3 calls which recursion function will call,
            //      to get this positions we have to use substring method on the process string,
            //      so the first location is 0, till my i
                            // 0,1
            // and so on...
            String s = p.substring(0, i);
            String e = p.substring(i, p.length());
            permutations(s + ch + e, up.substring(1));
        }
    }

    public static List<String> subSetWithList(String p, String up){
        List<String> ls = new ArrayList<>();
        if(up.isEmpty()){
            ls.add(p);
            return ls;
        }

        char ch = up.charAt(0);
        ls.addAll(subSetWithList(p + ch, up.substring(1)));
        ls.addAll(subSetWithList(p, up.substring(1)));
        return ls;
    }

    static List<List<Integer>> subSetForArr(int[] arr){
        // this is the iteration method.
        List<List<Integer>> outer = new ArrayList<>();


        // first create and empty list inside the outer List
        outer.add(new ArrayList<>());

        // now iterate with each number present in the given array, basically we are going add this element with each
        // and other element
        for (int num : arr) {
            // we have to create exactly same number of list to add new number, e.g. if initial list has 2 list, then this
            // loop will create that many list, for that we have to get the size of the outer list,
            // this statement will take care of that.
            int size = outer.size();
            // now we have the size of the outer list, now this below for loop will create that many lists. for each number
            for (int j = 0; j < size; j++) {
                // here we don't want to touch the previous list which are present in the outer list,
                // so we will create the copy of that arraylist, and add all the element in that list
                List<Integer> internal = new ArrayList<>(outer.get(j));
                // now add the number into newly crated arraylist
                internal.add(num);
                // finally add that list into the outer list.
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<String> mazeAllPath(String p, boolean[][] board, int row, int col){
        List<String> ls = new ArrayList<>();
        if(row == board.length - 1 && col == board[0].length - 1){
            ls.add(p);
            return ls;
        }

        if(!board[row][col]){
            return ls;
        }

        board[row][col] = false;

        if(row < board.length - 1) {
            ls.addAll((mazeAllPath(p + "down ", board, row + 1, col)));
        }
        if(row > 0){
            ls.addAll((mazeAllPath(p + "up ",board,row - 1, col)));
        }
        if(col < board.length - 1){
            ls.addAll((mazeAllPath(p + "right ", board, row, col + 1)));
        }
        if(col > 0){
            ls.addAll((mazeAllPath(p + "left ", board, row, col - 1)));
        }
        board[row][col] = true;
        return ls;
    }

    static int mazeAllPath1(String p, boolean[][] board, int row, int col){
        if(row == board.length - 1 && col == board[0].length - 1){
            board[row][col] = false;
            for(boolean[] line: board){
                System.out.println(Arrays.toString(line));
            }
            System.out.println();
            return 1;
        }

        if(!board[row][col]){
            return 0;
        }

        board[row][col] = false;
        int count = 0;
        if(row < board.length - 1) {
            count += mazeAllPath1(p + "down ", board, row + 1, col);
        }
        if(row > 0){
            count += mazeAllPath1(p + "up ",board,row - 1, col);
        }
        if(col < board.length - 1){
            count += mazeAllPath1(p + "right ", board, row, col + 1);
        }
        if(col > 0){
            count += mazeAllPath1(p + "left ", board, row, col - 1);
        }
        board[row][col] = true;
        return count;
    }


    static void mazeAllPathDisplay(int[][] board, int row, int col, int count){
        if(row == board.length - 1 && col == board[0].length - 1){
            board[row][col] = count;
            for(int[] line: board){
                System.out.println(Arrays.toString(line));
            }
            System.out.println();
            return;
        }

        if(board[row][col] != 0){
            return;
        }
        board[row][col] = count;

        if(row < board.length - 1) {
            mazeAllPathDisplay(board, row + 1, col, count + 1);
        }
        if(row > 0){
            mazeAllPathDisplay(board,row - 1, col, count + 1);
        }
        if(col < board.length - 1){
            mazeAllPathDisplay(board, row, col + 1, count + 1);
        }
        if(col > 0){
            mazeAllPathDisplay( board, row, col - 1, count + 1);
        }
        board[row][col] = 0;
    }
    public static void main(String[] args) {
//        changeAtoB("", "aab");
//        printSubSets("", "abc");
//        System.out.println(subSetWithList("", "abc"))
//        System.out.println('b' - 'a');
//        permutations("", "abc");
//        System.out.println(permutations1("", "abc"));
//        boolean[][] board = {
//                {true, true, true},
//                {true, true, true},
//                {true, true, true}
//        };
//        System.out.println(mazeCount(board, 2,2));
////        mazePath(board, 0,0,"");
////        System.out.println(mazeAllPath("", board, 0, 0));
//        int totalPaths = mazeAllPath1("",board, 0, 0);
//        System.out.println(totalPaths);

        int[][] arr = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };
        mazeAllPathDisplay(arr, 0, 0, 1);
    }

    static void mazePath(boolean[][] board, int row, int col, String p){
        if(row == board.length - 1 && col == board[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!board[row][col]){
            return;
        }
        if(row < board.length - 1) {
            mazePath(board, row + 1, col, p + 'D');
        }
        if(col < board.length - 1){
            mazePath(board, row, col + 1, p + 'R');
        }
    }

    static int mazeCount(boolean[][] board, int row, int col){
        if(row == 0 || col == 0){
            return 1;
        }
        if(!board[row][col]){
            return 0;
        }
        int left = mazeCount(board, row - 1, col);
        int right = mazeCount(board, row, col - 1);
        return left + right;
    }
    static void changeAtoB(String p, String up){
        if(up.isEmpty()){
            if(!p.isEmpty()){
                System.out.print(p + ", ");
            }
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a') {
            changeAtoB(p + 'b', up.substring(1));
        }else {
            changeAtoB(p + ch, up.substring(1));
        }
    }


    static void printSubSets(String p, String up){
        if(up.isEmpty()){
            if(p.isEmpty()){
                return;
            }
            System.out.print(p + " ");
            return;
        }

        // take the first character of the up
        char ch = up.charAt(0);
        printSubSets(p + ch, up.substring(1));
        printSubSets(p, up.substring(1));
    }

    static void quickSort(int[] arr, int low, int high){
        if(low > high){
            return;
        }

        int start = low;
        int end = high;

        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        // if array is already sorted then it won't perform the swaps
        while (start <= end){
            while (arr[start] < pivot){
                start++;
            }
            while (arr[end] > pivot){
                end--;
            }

            // and whenever u find the violation then just swap the found violations.
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        // now in the end all the elements which are greater than the current element will be after pivot and vice versa.
        // now divide the search area from low to end, and start to high;
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }


    static void mergeSortInplace(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = (start + end) / 2;

        mergeSortInplace(arr, start, mid);
        mergeSortInplace(arr, mid, end);

        mergeInplace(arr, start, mid, end);
    }

    static void mergeInplace(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < start && j < end){
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }

        while (i < start){
            mix[k++] = arr[i++];
        }
        while (j < end){
            mix[k++] = arr[j++];
        }


        // now here I have inserted all the elements in sorted manner in mix
        // now I have to replace all those elements in the actual array, in between their indices only
        for(int l = 0; l < mix.length; l++){
            mix[start + l] = mix[l];
        }
    }
    static int[] mSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mSort(Arrays.copyOfRange(arr, 0, mid)); // here end or mid is exclusive, means mid is excluded from the copy function.
        int[] right = mSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeSort(left, right);
    }

    static int[] mergeSort(int[] left, int[] right){
        int[] mix = new int[left.length + right.length];
        int sLeft = 0;
        int sRight = 0;
        int i = 0;

        while(sLeft < left.length && sRight < right.length){
            if(left[sLeft] < right[sRight]){
                mix[i] = left[sLeft];
                sLeft++;
            }else{
                mix[i] = right[sRight];
                sRight++;
            }
            i++;
        }

        while(sLeft < left.length){
            mix[i] = left[sLeft];
            i++;
            sLeft++;
        }
        while(sRight < right.length){
            mix[i] = right[sRight];
            i++;
            sRight++;
        }

        return mix;
    }

    static void printReverseTriangle(int row, int col){
        if(row == 0){
            return;
        }

        if(row > col){
            System.out.print("* ");
            printReverseTriangle(row, col + 1);
        }else{
            System.out.println();
            printReverseTriangle(row - 1, 0);
        }
    }

    static void printTriangle(int row, int col){
        if(row == 0){
            return;
        }

        if(row > col){
            printTriangle(row, ++col);
            System.out.print("* ");
        }else {
            printTriangle(row - 1, 0);
            System.out.println();
        }
    }

    static void printSquare(int row, int col){
        if(row == 0){
            return;
        }

        printCol(col);
        System.out.println();
        printSquare(row - 1, col);
    }

    static void bubbleSortRec(int[] arr, int row, int col){
        if(row == 0){
            return;
        }

        if(row > col){
            if(arr[col + 1] < arr[col]){
                swap(arr, col + 1, col);
            }
            bubbleSortRec(arr, row, col + 1);
        }else{
            bubbleSortRec(arr, row - 1, 0);
        }
    }

    static void selectionSort(int[] arr, int row, int col, int max){
        if(row == 0){
            return;
        }

        if(row > col){
            if(arr[max] < arr[col]){
                max = col;
            }
            selectionSort(arr, row, col + 1, max);
        }else{
            swap(arr, row - 1, max);
            selectionSort(arr, row - 1, 0, 0);
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void printCol(int col){
        if(col == 0){
            return;
        }

        System.out.print("* ");
        printCol(col - 1);
    }
//    public static void main(String[] args) {
////        printReverseTriangle(5, 0);
////        printTriangle(5, 0);
////        printSquare(5, 5);
//
//        int[] arr = {4,3,2,1};
//        System.out.println(Arrays.toString(mSort(arr)));
////        bubbleSortRec(arr, arr.length - 1, 0);
////        selectionSort(arr, arr.length, 0, 0);
////        System.out.println(Arrays.toString(arr));
////        int sum = 0;
////        int n = 2431;
////        while(n > 0){
////            int rem = n % 10;
////            sum = sum * 10 + rem;
////
////            n /= 10;
////        }
////        System.out.println(sum);
////
////        int ans = countZero(100, 0);
////        System.out.println(ans);
////
////        int[] arr = {2, 3, 3, 4, 5, 6,7};
////        System.out.println(binarySearch(arr, 0, arr.length - 1, 7));
////        System.out.println(normalSearch(arr, 0, 7));
////        System.out.println(findIndexWithRec(arr, 0, 3));
////        System.out.println(checkSortedOrNot(arr, 0));
//    }


    static int countZero(int n, int count){
        if(n == 0){
            return count;
        }
        int rem = n % 10;
        if(rem == 0){
            return countZero(n / 10, count + 1);
        }
        return countZero(n / 10, count);
    }

    static boolean checkSortedOrNot(int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }

        return arr[index] <= arr[index + 1] && checkSortedOrNot(arr, index + 1);
    }

    static int binarySearch(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binarySearch(arr, mid + 1, end, target);
        }
        return binarySearch(arr, start, mid - 1, target);
    }

    static boolean normalSearch(int[] arr, int index, int target){
        if(index == arr.length ){
            return false;
        }

        return arr[index] == target || normalSearch(arr, index + 1, target);
    }

    static List<Integer> findIndexWithRec(int[] arr, int index, int target){
        if(index == arr.length){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if(arr[index] == target){
            list.add(index);
        }
        List<Integer> ansFromBelowCall = findIndexWithRec(arr, index + 1, target);
        ansFromBelowCall.addAll(list);
        return ansFromBelowCall;
    }


    static int searchInRotatedArr(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        // now check if first half of the array is sorted or not
        if(arr[start] < arr[mid]){
            // if first half is sorted then check whether my target element lies into this range
            if(target < arr[mid] && target > arr[start]){
                return searchInRotatedArr(arr, start, mid - 1, target);
            }else{
                return searchInRotatedArr(arr, mid + 1, end, target);
            }
        }
        // now check whether my key lies in between my second half
        if(target > arr[mid] && target < arr[end]){
            return searchInRotatedArr(arr, mid + 1, end, target);
        }
        return searchInRotatedArr(arr, start, mid - 1, target);
    }


}



