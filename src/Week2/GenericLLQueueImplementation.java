package Week2;

public class GenericLLQueueImplementation<Item> {
    private Node first, last;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
