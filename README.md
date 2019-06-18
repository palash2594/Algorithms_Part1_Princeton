# Algorithms_Part1_Princeton

# Stacks
```
public class StackOfStrings
StackOfStrings()
void push(String item)
String pop()
boolean isEmpty()
```

## <u>Stack implementation using Linked List</u>

### inner class
`class Node`
`{`
`String item;`
`Node next;`
`}`


-  ## POP operation

### Save the first item
`String item = first.item`
### delete the first node
`first = first.next`

- ## PUSH operation

### Save the first element

`Node oldFirst = first;`

### create a new first Node

`first = new Node();`

### set the instance variable in the new node
`first.item = "new_string"`
`first.next = oldFirst`

```
public class LinkedListStackImplementation {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}

```

## <u> Stack implementation using Array</u>

- Use array s[] to store N items on stack.
- push(): add new item at s[n]
- pop(): remove item from s[n-1]

```
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
        String item = s[--N];
        S[N] = null;
        return item;
    }

    public void push(String item) {
        s[N++] = item;
    }
}


public class LinkedListStackImplementation {

    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
}

```


Loitering: Holding a reference to an object which is no longer needed.
For eg., in pop operation we are making the Nth entry as <u>Null</u>.


## <u> Resizing Array Implementation</u>

- The problem with the above implementaion that we need to keep the size fixed of the array, which is an incorrect API implementatio .
- To overcome that problem we increase the array by 2 times once it reached the capacity.
- Also reduce the capacity to half once the capacity reduced to 1/4th of the total capacity.



```
public class ResizingArrayImplementation {
    private String[] s;
    private int N = 0;

    public ResizingArrayImplementation() {
        s = new String[1];
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    public void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int  i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length /4) {
            resize(s.length / 2);
        }
        return item;
    }
}

```
