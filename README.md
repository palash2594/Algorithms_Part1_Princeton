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

# Queue
___

## <u>Queue implementation using Linked List</u>

### inner class
`class Node`
`{`
`String item;`
`Node next;`
`}`

Here we keep two pointers first and last which points to the head and tail respectively.

-  ## DEQUEUE operation

### Save item to return
`String item = first.item`

### Delete the first node
`first = first.next`

### return saved item
`return item`

- ## ENQUEUE operation

Add at the end

### Save link to the last node
`Node oldLast = last`;

### Create a new node for the end
```
Node last = new Node();
last.val = "item";
last.next = null;
```

### Link the new node at the end of the list
```
oldLast.next = last
```

## LinkedList implementation

```
public class LinkedListQueueImplementation {

    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
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

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}

```

# Iterators
___

- Has method that returns an Iterator.
- Iterator has methods hasNext() and next().

## Iterable Interface
```
public interface Iterable<Item> {
    Iterator<Item> iterator();
}
```

## Iterator Interface
```
public interface Iterator<Item> {
    boolean hasNext();
    Item next();
}
```

## Stack Iterator implementation

```

```

## Dijkstra's two stack algorithm

Evaluate the below expression:
(1 + ((2 + 3) * (4 * 5)))


Value - put on to the value stack
Operator - put on the operator stack
left parenthesis - ignore
right parenthesis - pop two values and one operator, do the operation and push the value back on the value stack

```
package Week2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

public class DijkstraTwoStackAlgorithm {

    public static void main(String[] args) {
        Stack<Double> value = new Stack<>();
        Stack<String> operator = new Stack<>();

        Scanner src = new Scanner(System.in);
        String input = src.next();

        for (int  i = 0; i < input.length(); i++){
            String s = Character.toString(input.charAt(i));
            if (s.equals("(")) {
                continue;
            } else if (s.equals("+")) {
                operator.push(s);
            } else if (s.equals("-")) {
                operator.push(s);
            } else if (s.equals("*")) {
                operator.push(s);
            } else if (s.equals("/")) {
                operator.push(s);
            } else if (s.equals(")")) {
                String ops = operator.pop();
                if (ops.equals("+")) {
                    value.push(value.pop() + value.pop());
                } else if (ops.equals("-")) {
                    value.push(value.pop() - value.pop());
                } else if (ops.equals("*")) {
                    value.push(value.pop() * value.pop());
                } else if (ops.equals("/")) {
                    value.push(value.pop() / value.pop());
                }
            } else {
                value.push(Double.parseDouble(s));
            }
        }

        System.out.println(value.pop());

    }
}
```

__Java generics__. Explain why Java prohibits generic array creation.
 Java arrays are covariant but Java generics are not: that is, __S𝚝𝚛𝚒𝚗𝚐[]__ is a subtype of __𝙾𝚋𝚓𝚎𝚌𝚝[]__, but __𝚂𝚝𝚊𝚌𝚔<𝚂𝚝𝚛𝚒𝚗𝚐>__ is not a subtype of __𝚂𝚝𝚊𝚌𝚔<𝙾𝚋𝚓𝚎𝚌𝚝>__.