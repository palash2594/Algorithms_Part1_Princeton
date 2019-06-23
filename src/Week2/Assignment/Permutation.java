package Week2.Assignment;


import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }

        int size = Integer.parseInt(args[0]);

        for (int i = 0; i < size; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
