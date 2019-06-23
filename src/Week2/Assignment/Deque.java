package Week2.Assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

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

    public Deque() {
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

    public void addFirst(Item item) {
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
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (first == null) {
            first = new Node<>(item);
            last = first;
        } else {
            Node<Item> oldLast = last;
            last = new Node<>(item);
            last.previous = oldLast;
        }
        size++;
    }

    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        size--;
        Item item = first.val;
        first = first.next;
        first.previous = null;
        if (size == 0) {
            first = null;
            last = null;
        }
        return item;
    }

    public Item removeLast() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        size--;
        Item item = last.val;
        last = last.previous;
        last.next = null;
        if (size == 0) {
            first = null;
            last = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> current = first;
        @Override
        public boolean hasNext() {
            return first == null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.val;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
