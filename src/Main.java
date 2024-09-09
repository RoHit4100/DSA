import java.util.*;

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
        Map<Integer, Integer> map = new HashMap<>(8);
        
        StringBuilder str = new StringBuilder("rohit");
        str.reverse();
        System.out.println(str);

        Integer n = 111;
    }

}
