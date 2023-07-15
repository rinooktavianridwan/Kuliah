
package HR8_HT_BST;

import java.util.Scanner;

public class MinHeapTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        HT heapTree = new HT();
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlahPerintah; i++) {
            String inputan = in.nextLine().trim();
            if (inputan.equalsIgnoreCase("TAMBAH ARRAY")) {
                String barisanAngka = in.nextLine().trim();
                String[] stringAngka = barisanAngka.split(" ");
                int[] kumpulanAngka = new int[stringAngka.length];
                for (int j = 0; j < stringAngka.length; j++) {
                    kumpulanAngka[j] = Integer.parseInt(stringAngka[j]);
                    heapTree.add(kumpulanAngka[j]);
                }
                System.out.println("Array angka berhasil ditambah");

            }
            if (inputan.equalsIgnoreCase("TAMBAH SATUAN")) {
                int angka = in.nextInt();
                in.nextLine();
                heapTree.add(angka);
                System.out.println("Satuan angka berhasil ditambah");
            }
            if (inputan.equalsIgnoreCase("PRINT PREORDER")) {
                if (heapTree.isEmpty()) {
                System.out.print("Preorder = " );
                heapTree.preorder(heapTree.root);
                System.out.println();
                }
                else {
                    System.out.println();
                }
            }
            if (inputan.equalsIgnoreCase("PRINT INORDER")) {
                if (heapTree.isEmpty()) {
                System.out.print("Inorder = ");
                heapTree.inorder(heapTree.root);
                System.out.println();
                }
                else {
                    System.out.println();
                }
            }
            if (inputan.equalsIgnoreCase("PRINT POSTORDER")) {
                if (heapTree.isEmpty()) {
                System.out.print("Postorder = ");
                heapTree.postorder(heapTree.root);
                System.out.println();
                }
                else {
                    System.out.println();
                }
            }
            if (inputan.equalsIgnoreCase("PRINT MIN")) {
                if (heapTree.isEmpty()) {
                    int min = heapTree.min();
                    String MIN = Integer.toString(min);
                    System.out.println("MIN = " + min);
                    System.out.print("Preorder = ");
                    heapTree.preorder(heapTree.root);
                    System.out.println();

                } else {
                    System.out.println();
                }
            }

        }

    }
}

class NodeHT {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeHT. */
    int data;
    NodeHT left, right, parent;

    public NodeHT(int data) {
        this.data = data;
        left = right = null;
    }

    public NodeHT(int data, NodeHT parent) {
        this.data = data;
        this.parent = parent;
        left = right = null;
    }
}

class HT {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named HT. */
    NodeHT root, last;

    public boolean isEmpty() {
        if (root != null) {
            return true;
        }
        return false;
    }

    public void add(int data) {
        if (root == null) {
            root = last = new NodeHT(data);
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeHT node = queue.dequeue();
            if (node.left == null) {
                node.left = new NodeHT(data, node);
                last = node.left;
                heapifyUp(node.left);
                return;
            } else {
                queue.enqueue(node.left);
            }
            if (node.right == null) {
                node.right = new NodeHT(data, node);
                last = node.right;
                heapifyUp(node.right);
                return;
            } else {
                queue.enqueue(node.right);
            }
        }
    }

    public void heapifyUp(NodeHT node) {
        if (node.parent == null) {
            return;
        }
        int parentData = node.parent.data;
        if (node.data < parentData) {
            node.parent.data = node.data;
            node.data = parentData;
            heapifyUp(node.parent);
        }
    }

    public int min() {
        if (root == null)
            return -1;
        int min = root.data;
        if (root == last) { //jika node hanya 1
            root = last = null;
        } else {
            if (last.parent != null) { //nilai node terakhir jadi root
                root.data = last.data;
                if (last == last.parent.right) {
                    last.parent.right = null;
                    last = last.parent.left;
                } else { //mencari node terakhir jika last ada di sebelah kiri
                    last.parent.left = null;
                    Queue queue = new Queue();
                    queue.enqueue(root);
                    last = root;
                    while (!queue.isEmpty()) {
                        NodeHT node = queue.dequeue();
                        if (node.left == null) {
                            break;
                        } else {
                            queue.enqueue(node.left);
                            last = node.left;
                        }
                        if (node.right == null) {
                            break;
                        } else {
                            queue.enqueue(node.right);
                            last = node.right;
                        }
                    }
                }
            } else {
                root = last;
            }
            heapifyDown(root);
        }

        return min;
    }

    private void heapifyDown(NodeHT node) {
        if (!isEmpty()) {
            return;
        }

        int parentData = node.data;
        int leftData = (node.left != null) ? node.left.data : Integer.MAX_VALUE;
        int rightData = (node.right != null) ? node.right.data : Integer.MAX_VALUE;

        if (parentData > leftData || parentData > rightData) {
            if (leftData < rightData) {
                node.data = leftData;
                node.left.data = parentData;
                heapifyDown(node.left);
            } else {
                node.data = rightData;
                node.right.data = parentData;
                heapifyDown(node.right);
            }
        }
    }

    public void preorder(NodeHT current) {
        if (root == null)
            return;
        System.out.print(current.data + " ");
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }


    public void inorder(NodeHT current) {
        if (root == null) {
            return;
        }
        if (current.left != null) {
            inorder(current.left);
        }
        System.out.print(current.data + " ");
        if (current.right != null) {
            inorder(current.right);
        }
    }

    public void postorder(NodeHT current) {
        if (root == null) {
            return;
        }
        if (current.left != null) {
            postorder(current.left);
        }
        if (current.right != null) {
            postorder(current.right);
        }
        System.out.print(current.data + " ");
    }
}

class NodeQueue {

    NodeHT data;
    NodeQueue next;

    public NodeQueue(NodeHT data) {
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

    public void enqueue(NodeHT data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public NodeHT dequeue() {
        if (!isEmpty()) {
            NodeHT temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        return null;
    }

}
