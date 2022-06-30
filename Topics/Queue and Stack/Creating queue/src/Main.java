import java.util.*;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 10; i >= 0; i--) {
            deq.offerFirst(i);
        }

        System.out.println(deq);
    }
}