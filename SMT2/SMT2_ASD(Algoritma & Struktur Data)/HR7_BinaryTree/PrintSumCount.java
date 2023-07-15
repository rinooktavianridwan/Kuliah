package HR7_BinaryTree;

import java.util.Scanner;

public class PrintSumCount {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BT binary = new BT();
        String angka[] = in.nextLine().split(" ");
        int batas = in.nextInt();

        for (int i = 0; i < angka.length; i++) {
            binary.add(Integer.parseInt(angka[i]));
        }

        String hasilBinary = binary.preorder(binary.root);
        String pemrosesan[] = hasilBinary.split(" ");

        binary.print(batas, pemrosesan);
        int jumlah = binary.jumlah(batas, pemrosesan);
        System.out.println("Sum tree : " + jumlah);
        int count = binary.count(batas, pemrosesan);
        System.out.println("Count tree : " + count);

    }
}

class NodeBT {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeBT. */
    int data;
    NodeBT left, right;

    public NodeBT(int data) {
        this.data = data;
        left = right = null;
    }
}

class BT {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named BT. */
    NodeBT root;

    public void add(int input) {
        if (root == null) {
            root = new NodeBT(input);
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeBT pointer = queue.dequeue();
            if (pointer.left == null) {
                pointer.left = new NodeBT(input);
                return;
            } else {
                queue.enqueue(pointer.left);
            }

            if (pointer.right == null) {
                pointer.right = new NodeBT(input);
                return;
            } else {
                queue.enqueue(pointer.right);
            }
        }
    }

    public String preorder(NodeBT current) {
        String binarytree = "";
        binarytree += current.data + " ";

        if (current.left != null) {
            binarytree += preorder(current.left);
        }
        if (current.right != null) {
            binarytree += preorder(current.right);
        }
        return binarytree;
    }

    public void print(int batas, String hasilBinary[]) {
        System.out.print("Print tree : ");
        for (int i = 0; i < hasilBinary.length; i++) {
            System.out.print(hasilBinary[i] + " ");
            if (Integer.parseInt(hasilBinary[i]) == batas) {
                System.out.println();
                break;
            }
        }
    }

    public int jumlah(int batas, String hasilBinary[]) {
        int total = 0;

        for (int i = 0; i < hasilBinary.length; i++) {
            total += Integer.parseInt(hasilBinary[i]);
            if (Integer.parseInt(hasilBinary[i]) == batas) {
                break;
            }
        }
        return total;
    }

    public int count(int batas, String hasilBinary[]) {
        int count = 0;
        for (int i = 0; i < hasilBinary.length; i++) {
            count++;
            if (Integer.parseInt(hasilBinary[i]) == batas) {
                break;
            }
        }
        return count;
    }
}

class NodeQueue {

    NodeBT data;
    NodeQueue next;

    public NodeQueue(NodeBT data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {

    NodeQueue head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(NodeBT data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public NodeBT dequeue() {
        if (!isEmpty()) {
            NodeBT temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        return null;
    }
}