package Week2.Assignment;

public class Tester {

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        rq.enqueue(622);
        rq.enqueue(189);
        rq.size();
        rq.enqueue(504);
        rq.enqueue(810);
        rq.isEmpty();
        rq.enqueue(361);
        rq.enqueue(257);
        rq.enqueue(206);
        rq.size();
        rq.dequeue();
    }
}
