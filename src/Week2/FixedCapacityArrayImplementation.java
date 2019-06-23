package Week2;

public class FixedCapacityArrayImplementation {
    private String[] s;
    private int N = 0;

    public FixedCapacityArrayImplementation(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public String pop() {
        return s[N--];
    }

    public void push(String item) {
        s[N++] = item;
    }
}
