package Week2.Assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node<Item> {
        Item val;
        Node<Item> next;
        Node<Item> previous;

        private Node(Item val) {
            this.val = val;
            next = null;
            previous = null;
        }
    }

    private Node<Item> first;
    private Node<Item> last;

    private int size;

    public RandomizedQueue() {
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size () {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (first == null) {
            first = new Node<>(item);
            last = first;
        } else {
            Node<Item> oldFirst = first;
            first = new Node<>(item);
            first.next = oldFirst;
            oldFirst.previous = first;
        }
        size++;
    }

    public Item dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        Random rand = new Random();

        int n = 4;
        System.out.println(n);
        Node<Item> current = first;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        Item item = current.val;

        size--;
        if (size == 0) {
            first = null;
            last = null;
            return item;
        }

        if (n == 0) { // first element
            current.next.previous = null;
            first = first.next;
        } else if (n == size) { // last element
            current.previous.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        return item;
    }

    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Random rand = new Random();
        int n = rand.nextInt(size);
        Node<Item> current = first;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        return current.val;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] duplicateItems;
        private int duplicateSize;

        private RandomizedQueueIterator() {
            duplicateSize = size;
            duplicateItems = (Item[])new Object[duplicateSize];
            Node<Item> current = first;

            for (int i = 0; i < duplicateSize; i++) {
                duplicateItems[i] = current.val;
                current = current.next;
            }
        }

        private Node<Item> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            if (duplicateSize == 1) {
                return duplicateItems[0];
            }

            Random rand = new Random();

            int pos = rand.nextInt(duplicateSize);

            Item item = duplicateItems[pos];
            duplicateItems[pos] = duplicateItems[duplicateSize - 1];
            duplicateItems[duplicateSize - 1] = null;
            duplicateSize--;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

