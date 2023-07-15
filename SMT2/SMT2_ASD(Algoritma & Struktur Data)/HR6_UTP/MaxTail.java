package HR6_UTP;

import java.util.Scanner;

public class MaxTail {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        SLL penyimpanan = new SLL();
        int jumlahAngka = in.nextInt();

        for (int i = 0; i < jumlahAngka; i++) {
            int masukanAngka = in.nextInt();
            penyimpanan.addLast(masukanAngka);
        }
        penyimpanan.cekAngkaTerbesar();
        System.out.println(penyimpanan.jumlahAngka());

    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {

    Node head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public int tail() {
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(int data) {
        Node input = new Node(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void cekAngkaTerbesar() {
        Node pointer = head;
        Node makAngka = pointer;
        while (pointer != null) {
            if (pointer.data > makAngka.data) {
                makAngka = pointer;
            }
            pointer = pointer.next;
        }
        Node pointer1 = head;
        while (pointer1 != tail) {
            if (pointer1.data < makAngka.data) {
                if (pointer1 == head) {
                    removeFirst();
                    pointer1 = head;
                } else {
                    deleteNode(pointer1.data);
                    pointer1 = pointer1.next;
                }
            } else {
                pointer1 = pointer1.next;
            }
        }
    }

    public int jumlahAngka() {
        int totalAngka = 0;
        Node pointer = head;
        while (pointer != null) {
            totalAngka += pointer.data;
            pointer = pointer.next;
        }
        return totalAngka;
    }

    public void deleteNode(int key) {
        if (head != null) {
            Node temp = head;
            if (temp.data == key && temp == head) {
                removeFirst();
            } else {
                while (temp.next != null && temp.next.data != key) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    temp.next = temp.next.next;
                }
            }
        }
    }

    public void removeFirst() {
        head = head.next;
        size--;
    }

    public void removeLast() {
        Node pointer = head;
        while (pointer.next != tail) {
            pointer = pointer.next;
        }
        pointer.next = null;
        tail = pointer;
        size--;
    }

    public void print() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }
}
