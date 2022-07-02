import java.util.*;
import java.io.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Queue : " + q);
        q.remove();
        System.out.println("Queue : " + q);

        System.out.println("Poll : " + q.poll() + " Peek : " + q.peek() + " size : " + q.size());

    }
}