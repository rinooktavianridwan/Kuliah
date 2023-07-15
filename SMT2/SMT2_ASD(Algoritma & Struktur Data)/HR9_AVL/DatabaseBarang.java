
package HR9_AVL;

import java.util.Scanner;

public class DatabaseBarang {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        AVL avl = new AVL();
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlahPerintah; i++) {
            String perintah = in.nextLine();
            if (perintah.equalsIgnoreCase("TAMBAH BARANG")) {
                int jumlahBarang = 0;
                String masukanBarang = in.nextLine();
                String[] kumpulanBarang = masukanBarang.split(";");
                for (int j = 0; j < kumpulanBarang.length; j++) {
                    String[] satuBarang = kumpulanBarang[j].split(",");
                    avl.add(satuBarang[0], Integer.parseInt(satuBarang[1]));
                    jumlahBarang++;
                }
                System.out.println("Data " + jumlahBarang + " barang berhasil ditambah");
                System.out.println();

            } else if (perintah.equalsIgnoreCase("CARI BARANG")) {
                String typePrint = in.next();
                String dari = in.next();
                int patokan = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                if (typePrint.equalsIgnoreCase("LEBIH") && dari.equalsIgnoreCase("DARI")) {
                    avl.searchLebihDari(avl.root, patokan);
                    System.out.println();

                } else if (typePrint.equalsIgnoreCase("KURANG") && dari.equalsIgnoreCase("DARI")) {
                    avl.searchKurangDari(avl.root, patokan);
                    System.out.println();
                } else if (typePrint.equalsIgnoreCase("SAMA") && dari.equalsIgnoreCase("DENGAN")) {
                    avl.search(avl.root, patokan);
                    System.out.println();
                }
            }

        }
    }
}

class NodeAVL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeAVL. */
    String namaBarang;
    int hargaBarang, height;
    NodeAVL left, right;

    NodeAVL(String namaBarang, int hargaBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        height = 1;
        left = right = null;
    }
}

class AVL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named AVL. */
    NodeAVL root;

    public int height(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    // fungsi untuk rotasi kanan
    public NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;
        // rotasi kanan
        x.right = y;
        y.left = T2;
        // perbarui tinggi dari node
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // fungsi untuk rotasi kiri
    public NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;
        // rotasi kiri
        y.left = x;
        x.right = T2;
        // perbarui tinggi dari node
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // cek faktor keseimbangan node
    public int getBalance(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public void add(String namaBarang, int hargaBarang) {
        root = add(root, namaBarang, hargaBarang);
    }

    public NodeAVL add(NodeAVL node, String namaBarang, int hargaBarang) {
        if (node == null) {
            return (new NodeAVL(namaBarang, hargaBarang));
        }
        if (hargaBarang < node.hargaBarang) {
            node.left = add(node.left, namaBarang, hargaBarang);
        } else if (hargaBarang > node.hargaBarang) {
            node.right = add(node.right, namaBarang, hargaBarang);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        // right rotation (left of left)
        if (balance > 1 && hargaBarang < node.left.hargaBarang) {
            return rightRotate(node);
        }
        // left rotation (right of right)
        if (balance < -1 && hargaBarang > node.right.hargaBarang) {
            return leftRotate(node);
        }
        // left-right rotation (right of left)
        if (balance > 1 && hargaBarang > node.left.hargaBarang) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right-left rotation (left of right)
        if (balance < -1 && hargaBarang < node.right.hargaBarang) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public int nilaiTerkecil(NodeAVL root) {
        if (root.left == null) {
            return root.hargaBarang;
        } else {
            return nilaiTerkecil(root.left);
        }
    }

    public int nilaiTerbesar(NodeAVL root) {
        if (root.right == null) {
            return root.hargaBarang;
        } else {
            return nilaiTerbesar(root.right);
        }
    }

    public void search(NodeAVL root, int hargaBarang) {
        NodeAVL temp = root;
        if (temp == null) {
            System.out.println("Data barang tidak ditemukan");
            return;
        }
        int jumlah = 1;
        boolean kondisi = false;
        String lastResult = null;
        while (temp != null) {
            if (temp.hargaBarang == hargaBarang) {
                String result = temp.namaBarang + " = Rp" + temp.hargaBarang;
                if (!result.equals(lastResult)) {
                    System.out.println(result);
                    jumlah++;
                    lastResult = result;
                    kondisi = true;
                }
            }
            if (temp.hargaBarang >= hargaBarang) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (kondisi == false) {
            System.out.println("Data barang tidak ditemukan");
        }
    }

    public void searchLebihDari(NodeAVL root, int hargaBarang) {
        Stack barang = new Stack();
        searchLebihDariHelper(root, hargaBarang, barang);

        if (barang.isEmpty()) {
            System.out.println("Data barang tidak ditemukan");
        } else {
            barang.urutanTerbesar();
            barang.print();
        }
    }

    public void searchLebihDariHelper(NodeAVL node, int hargaBarang, Stack barang) {
        if (node == null) {
            return;
        }
        if (node.hargaBarang > hargaBarang) {
            barang.push(node.namaBarang, node.hargaBarang);
        }
        searchLebihDariHelper(node.left, hargaBarang, barang);
        searchLebihDariHelper(node.right, hargaBarang, barang);
    }

    public void searchKurangDari(NodeAVL root, int hargaBarang) {
        Stack barang = new Stack();
        searchKurangDariHelper(root, hargaBarang, barang);
        if (barang.isEmpty()) {
            System.out.println("Data barang tidak ditemukan");
        } else {
            barang.urutanTerbesar();
            barang.print();
        }
    }

    public void searchKurangDariHelper(NodeAVL node, int hargaBarang, Stack barang) {
        if (node == null) {
            return;
        }
        if (node.hargaBarang < hargaBarang) {
            barang.push(node.namaBarang, node.hargaBarang);
        }
        searchKurangDariHelper(node.left, hargaBarang, barang);
        searchKurangDariHelper(node.right, hargaBarang, barang);
    }

}

class NodeStack {

    String namaBarang;
    int hargaBarang;
    NodeStack next;

    NodeStack(String namaBarang, int hargaBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.next = null;
    }
}

class Stack {

    NodeStack head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String namaBarang, int hargaBarang) {
        NodeStack input = new NodeStack(namaBarang, hargaBarang);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void push(NodeStack input) {
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public NodeStack pop() {
        if (!isEmpty()) {
            if (size == 1) {
                NodeStack removed = head;
                head = tail = null;
                size--;
                return removed;
            } else {
                NodeStack pointer = head;
                while (pointer.next != tail) {
                    pointer = pointer.next;
                }
                NodeStack removed = tail;
                pointer.next = null;
                tail = pointer;
                size--;
                return removed;
            }
        }
        return null; 
    }

    public void print() {
        NodeStack pointer = head;
        int jumlah = 1;
        while (pointer != null) {
            System.out.println(jumlah + ". " + pointer.namaBarang + " = Rp" + pointer.hargaBarang);
            jumlah++;
            pointer = pointer.next;
        }
    }

    public void urutanTerbesar() {
        head = bantuanSort(head);
        NodeStack pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        tail = pointer;
    }

    private NodeStack bantuanSort(NodeStack head) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeStack tengah = cariNilaiTengah(head);
        NodeStack setelahTengah = tengah.next;
        tengah.next = null;
        NodeStack kiri = bantuanSort(head);
        NodeStack kanan = bantuanSort(setelahTengah);
        return bantuanBantuanSort(kiri, kanan);
    }

    private NodeStack bantuanBantuanSort(NodeStack left, NodeStack right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        NodeStack result;
        if (left.hargaBarang >= right.hargaBarang) {
            result = left;
            result.next = bantuanBantuanSort(left.next, right);
        } else {
            result = right;
            result.next = bantuanBantuanSort(left, right.next);
        }
        return result;
    }

    private NodeStack cariNilaiTengah(NodeStack head) {
        if (head == null) {
            return head;
        }
        NodeStack pertama = head;
        NodeStack kedua = head;
        while (kedua.next != null && kedua.next.next != null) {
            pertama = pertama.next;
            kedua = kedua.next.next;
        }
        return pertama;
    }
}

