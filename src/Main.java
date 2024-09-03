import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println((double)5/4);
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        Queue<Integer> qu2 = new LinkedList<>();
        que.forEach(qu2::offer);
        for (Queue<Integer> queue : Arrays.asList(que, qu2)) {
            System.out.println(queue);
        }

        StringBuilder str = new StringBuilder(1231+"");
        System.out.println(str);
    }
}
