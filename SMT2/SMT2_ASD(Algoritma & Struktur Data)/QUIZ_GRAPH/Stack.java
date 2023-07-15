package QUIZ_GRAPH;

class Stack {

    Node head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void pop() {
        if (size == 1) {
            head = head.next;
            size--;
        } else if (!isEmpty()) {
            Node pointer = head;
            while (pointer.next != tail) {
                pointer = pointer.next;
            }
            pointer.next = null;
            tail = pointer;
            size--;
        }
    }

    public int top() {
        return tail.koorPeta;
    }

    public boolean isExists(int data) {
        Node pointer = head;
        while (pointer != null) {
            if (pointer.koorPeta == data) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void print() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.koorPeta + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }
}
