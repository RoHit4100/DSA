package Strivers.BinarySearchQuestions.BSOnNumbers;

import java.lang.management.MemoryNotificationInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;

public class AllocateBooks {
    static int findPageOptimized(ArrayList<Integer> books, int k){
        int n = books.size();
        if(k > n){
            return -1;
        }

        // the minimum pages a student can hold is the max pages of a book
        // and the maximum pages a student can hold is sum of all the pages
        // so find the max and sum of all the book pages
        int totalPages = 0;
        int maxPageOfABook = Integer.MIN_VALUE;
        for(int book: books){
            maxPageOfABook = Math.max(maxPageOfABook, book);
            totalPages += book;
        }

        int start = maxPageOfABook;
        int end = totalPages;

        while (start <= end){
            int mid = start + (end - start) / 2;

            int students = getTheCountOfStudents(books, mid);
            if(students <= k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int ans = findPages(books, 4);
        System.out.println(ans);
        System.out.println(findPageOptimized(books, 4));
    }

    // brute for approach
    static int findPages(ArrayList<Integer> books, int k){
        // In this problem we have to find the minimum of maximum pages a student can get in each set
        // k is number of students, and here every student has to get the book
        // if k is more than length of total books return -1
        int n = books.size();
        if(k > n){
            return -1;
        }

        // the minimum pages a student can hold is the max pages of a book
        // and the maximum pages a student can hold is sum of all the pages
        // so find the max and sum of all the book pages
        int totalPages = 0;
        int maxPageOfABook = Integer.MIN_VALUE;
        for(int book: books){
            maxPageOfABook = Math.max(maxPageOfABook, book);
            totalPages += book;
        }

        int start = maxPageOfABook;
        int end = totalPages;
        for(int i = start; i <= end; i++){
            int countOfTotalStudents = getTheCountOfStudents(books, i);
            if(countOfTotalStudents == k){
                return i;
            }
        }
        return end;
    }

    static int getTheCountOfStudents(ArrayList<Integer> books, int totalPages){
        int students = 1;
        int pages = 0;
        for(int book: books){
            if(book + pages <= totalPages){
                pages += book;
            }else{
                students++;
                pages = book;
            }
        }
        return students;
    }
}
