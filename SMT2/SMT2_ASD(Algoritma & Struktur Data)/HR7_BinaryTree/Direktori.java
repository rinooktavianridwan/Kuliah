package HR7_BinaryTree;


import java.util.Scanner;

public class Direktori {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        BT binaryDirektory = new BT();
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlahPerintah; i++) {
            String masukan = in.nextLine();
            if ("Tambah".equalsIgnoreCase(masukan)) {
                String nama = in.next().trim();
                int memory = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                binaryDirektory.add(nama, memory);
                System.out.println("Direktori " + nama + " berhasil ditambah dengan memori sebesar " + memory);
            }
            if ("CARI".equalsIgnoreCase(masukan)) {
                String nama = in.nextLine().trim();
                String petaBinary = binaryDirektory.cariJalanTerpendek(binaryDirektory.root, nama);
                System.out.println(petaBinary);
            }
            if ("HITUNG".equalsIgnoreCase(masukan)) {
                String nama = in.nextLine().trim();
                binaryDirektory.countMemory(nama);
            }

        }
    }
}

class NodeBT {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeBT. */
    String data;
    int memory;
    NodeBT left, right;

    public NodeBT(String data, int memory) {
        this.data = data;
        this.memory = memory;
        left = null;
        right = null;
    }

}

class BT {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named BT. */
    NodeBT root;

    public void add(String input, int memory) {
        if (root == null) {
            root = new NodeBT(input, memory);
            return;
        }
        StackQueue queue = new StackQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeBT pointer = queue.dequeue();
            if (pointer.left == null) {
                pointer.left = new NodeBT(input, memory);
                return;
            } else {
                queue.enqueue(pointer.left);
            }
            if (pointer.right == null) {
                pointer.right = new NodeBT(input, memory);
                return;
            } else {
                queue.enqueue(pointer.right);
            }
        }
    }

    public String cariJalanTerpendek(NodeBT root, String input) {
        StackQueue historyJalan = new StackQueue();
        int kondisi = 0;
        NodeBT nodeSementara = root;
        historyJalan.addFirst(nodeSementara);
        while (cariNodeChild(nodeSementara, input)) {
            if (nodeSementara.data.equals(input)) {
                kondisi = 1;
                break;
            }
            if (nodeSementara.left != null && cariNodeChild(nodeSementara.left, input)) {
                historyJalan.addFirst(nodeSementara.left);
                nodeSementara = nodeSementara.left;
            } else if (nodeSementara.right != null && cariNodeChild(nodeSementara.right, input)) {
                historyJalan.addFirst(nodeSementara.right);
                nodeSementara = nodeSementara.right;
            }
        }

        if (kondisi == 1) {
            StackQueue jalanKebenaran = new StackQueue();
            while (!historyJalan.isEmpty()) {
                jalanKebenaran.addFirst(historyJalan.removeFirst());
            }
            String hasil ="";
            StringBuilder sb = new StringBuilder();
            while (!jalanKebenaran.isEmpty()) {
                hasil +=jalanKebenaran.removeFirst().data + " > ";
            }
            hasil = hasil.substring(0, hasil.length() - 3);
            return hasil;
        } else {
            String nt = "Direktori tidak ditemukan";
            return nt;
        }
    }

    public boolean cariNodeChild(NodeBT root, String input) {
        if (root == null) {
            return false;
        } else if (root.data.equalsIgnoreCase(input)) {
            return true;
        } else {
            boolean left = cariNodeChild(root.left, input);
            boolean right = cariNodeChild(root.right, input);
            return left || right;
        }
    }

    public NodeBT cariNodeParent(NodeBT nodeParent, String input) {
        if (nodeParent == null) {
            return null;
        }
        if (nodeParent.data.equals(input)) {
            return nodeParent;
        }
        NodeBT left = cariNodeParent(nodeParent.left, input);
        if (left != null) {
            return left;
        }
        NodeBT right = cariNodeParent(nodeParent.right, input);
        if (right != null) {
            return right;
        }
        return null;
    }

    public int hitungMemory(NodeBT nodeParent) {
        if (nodeParent == null) {
            return 0;
        }
        int total = nodeParent.memory;
        total += hitungMemory(nodeParent.left);
        total += hitungMemory(nodeParent.right);
        return total;
    }

    public void countMemory(String input) {
        NodeBT cariNode = cariNodeParent(root, input);
        if (cariNode == null) {
            System.out.println("Direktori tidak ditemukan");
        } else {
            int totalMemory = hitungMemory(cariNode);
            System.out.println("Besar memori " + input + " = " + totalMemory);
        }
    }

}

class NodeStack {

    NodeBT data;
    NodeStack next;
    NodeStack prev;

    public NodeStack(NodeBT data) {
        this.data = data;
        this.next = null;
        this.prev = null;
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

class StackQueue {

    NodeQueue head, tail;
    NodeStack first, last;
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

    public void addFirst(NodeBT data) {
        NodeStack input = new NodeStack(data);
        if (isEmpty()) {
            first = last = input;
        } else {
            input.next = first;
            first.prev = input;
            first = input;
        }
        size++;
    }

    public NodeBT removeFirst() {
        if (!isEmpty()) {
            NodeBT node = first.data;
            if (first == last) {
                first = last = null;
            } else {
                first = first.next;
                first.prev = null;
            }
            size--;
            return node;
        }
        return null;
    }

    public NodeBT top() {
        if (isEmpty()) {
            return null;
        } else {
            return last.data;
        }
    }

    public void addLast(NodeBT data) {
        NodeStack input = new NodeStack(data);
        if (isEmpty()) {
            first = last = input;
        } else {
            last.next = input;
            input.prev = last;
            last = input;
        }
        size++;
    }

}
