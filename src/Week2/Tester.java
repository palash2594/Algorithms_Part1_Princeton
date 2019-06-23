package Week2;

import java.util.Iterator;

public class Tester {
    public static void main(String[] args) {
        LinkedListQueueImplementation lq = new LinkedListQueueImplementation();

        System.out.println(lq.isEmpty());
        System.out.println(lq.dequeue());
        lq.enqueue("hello");
        lq.enqueue("world");
        System.out.println(lq.isEmpty());

        System.out.println("\nStack\n");

        GenericLLStackImplementation<String> gs = new GenericLLStackImplementation<>();
        gs.push("hello");
        gs.push("world");

        Iterator<String> it = gs.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
