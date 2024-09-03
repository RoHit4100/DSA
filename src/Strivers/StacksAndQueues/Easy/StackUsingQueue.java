package Strivers.StacksAndQueues.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // I will create a pop, and top efficient stack using queue
            // first add the x into queue
            queue.offer(x);

            // now remove elements from queue, till size is 1
            int size = queue.size();

            while (size > 1){ // this loop will take out the first element of the queue and then push back at the last of the queue
                queue.offer(queue.poll());
                size--;
            }
        }

        public int pop() {
            if(queue.isEmpty()){
                return -1;
            }
            return queue.poll();
        }

        public int top() {
            if(queue.isEmpty()){
                return -1;
            }
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
